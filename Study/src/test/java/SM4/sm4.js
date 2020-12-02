// define(function(require, exports, module) {

var SM4_ENCRYPT = 1;
var SM4_DECRYPT = 0;
var default_key = "We@53&es&esT*7%s";

function sm4_context() {
    this.mode = 0;
    this.sk = [];
}

function GET_ULONG_BE(b, i) {
    return (b[i] << 24) | (b[i + 1] << 16) | (b[i + 2]) << 8 | (b[i + 3]);
}

function PUT_ULONG_BE(n, b, i) {
    b[i] = n >>> 24;
    b[i + 1] = n >>> 16;
    b[i + 2] = n >>> 8;
    b[i + 3] = n;
}

function ROTL(x, n) {
    var a = (x & 0xFFFFFFFF) << n;
    var b = x >>> (32 - n);

    return a | b;
}

var SboxTable = [
    [0xd6, 0x90, 0xe9, 0xfe, 0xcc, 0xe1, 0x3d, 0xb7, 0x16, 0xb6, 0x14, 0xc2, 0x28, 0xfb, 0x2c, 0x05],
    [0x2b, 0x67, 0x9a, 0x76, 0x2a, 0xbe, 0x04, 0xc3, 0xaa, 0x44, 0x13, 0x26, 0x49, 0x86, 0x06, 0x99],
    [0x9c, 0x42, 0x50, 0xf4, 0x91, 0xef, 0x98, 0x7a, 0x33, 0x54, 0x0b, 0x43, 0xed, 0xcf, 0xac, 0x62],
    [0xe4, 0xb3, 0x1c, 0xa9, 0xc9, 0x08, 0xe8, 0x95, 0x80, 0xdf, 0x94, 0xfa, 0x75, 0x8f, 0x3f, 0xa6],
    [0x47, 0x07, 0xa7, 0xfc, 0xf3, 0x73, 0x17, 0xba, 0x83, 0x59, 0x3c, 0x19, 0xe6, 0x85, 0x4f, 0xa8],
    [0x68, 0x6b, 0x81, 0xb2, 0x71, 0x64, 0xda, 0x8b, 0xf8, 0xeb, 0x0f, 0x4b, 0x70, 0x56, 0x9d, 0x35],
    [0x1e, 0x24, 0x0e, 0x5e, 0x63, 0x58, 0xd1, 0xa2, 0x25, 0x22, 0x7c, 0x3b, 0x01, 0x21, 0x78, 0x87],
    [0xd4, 0x00, 0x46, 0x57, 0x9f, 0xd3, 0x27, 0x52, 0x4c, 0x36, 0x02, 0xe7, 0xa0, 0xc4, 0xc8, 0x9e],
    [0xea, 0xbf, 0x8a, 0xd2, 0x40, 0xc7, 0x38, 0xb5, 0xa3, 0xf7, 0xf2, 0xce, 0xf9, 0x61, 0x15, 0xa1],
    [0xe0, 0xae, 0x5d, 0xa4, 0x9b, 0x34, 0x1a, 0x55, 0xad, 0x93, 0x32, 0x30, 0xf5, 0x8c, 0xb1, 0xe3],
    [0x1d, 0xf6, 0xe2, 0x2e, 0x82, 0x66, 0xca, 0x60, 0xc0, 0x29, 0x23, 0xab, 0x0d, 0x53, 0x4e, 0x6f],
    [0xd5, 0xdb, 0x37, 0x45, 0xde, 0xfd, 0x8e, 0x2f, 0x03, 0xff, 0x6a, 0x72, 0x6d, 0x6c, 0x5b, 0x51],
    [0x8d, 0x1b, 0xaf, 0x92, 0xbb, 0xdd, 0xbc, 0x7f, 0x11, 0xd9, 0x5c, 0x41, 0x1f, 0x10, 0x5a, 0xd8],
    [0x0a, 0xc1, 0x31, 0x88, 0xa5, 0xcd, 0x7b, 0xbd, 0x2d, 0x74, 0xd0, 0x12, 0xb8, 0xe5, 0xb4, 0xb0],
    [0x89, 0x69, 0x97, 0x4a, 0x0c, 0x96, 0x77, 0x7e, 0x65, 0xb9, 0xf1, 0x09, 0xc5, 0x6e, 0xc6, 0x84],
    [0x18, 0xf0, 0x7d, 0xec, 0x3a, 0xdc, 0x4d, 0x20, 0x79, 0xee, 0x5f, 0x3e, 0xd7, 0xcb, 0x39, 0x48]
];

var FK = [0xa3b1bac6, 0x56aa3350, 0x677d9197, 0xb27022dc];
var CK = [
    0x00070e15, 0x1c232a31, 0x383f464d, 0x545b6269,
    0x70777e85, 0x8c939aa1, 0xa8afb6bd, 0xc4cbd2d9,
    0xe0e7eef5, 0xfc030a11, 0x181f262d, 0x343b4249,
    0x50575e65, 0x6c737a81, 0x888f969d, 0xa4abb2b9,
    0xc0c7ced5, 0xdce3eaf1, 0xf8ff060d, 0x141b2229,
    0x30373e45, 0x4c535a61, 0x686f767d, 0x848b9299,
    0xa0a7aeb5, 0xbcc3cad1, 0xd8dfe6ed, 0xf4fb0209,
    0x10171e25, 0x2c333a41, 0x484f565d, 0x646b7279
];

function sm4Sbox(n) {
    var l = n >>> 4;
    var r = n % 16;
    return SboxTable[l][r];
}

function sm4Lt(ka) {
    var bb = 0;
    var c = 0;
    var a = new Uint8Array(4);
    var b = new Array(4);
    PUT_ULONG_BE(ka, a, 0);
    b[0] = sm4Sbox(a[0]);
    b[1] = sm4Sbox(a[1]);
    b[2] = sm4Sbox(a[2]);
    b[3] = sm4Sbox(a[3]);
    bb = GET_ULONG_BE(b, 0);

    c = bb ^ (ROTL(bb, 2)) ^ (ROTL(bb, 10)) ^ (ROTL(bb, 18)) ^ (ROTL(bb, 24));
    return c;
}

function sm4F(x0, x1, x2, x3, rk) {
    return (x0 ^ sm4Lt(x1 ^ x2 ^ x3 ^ rk));
}

function sm4CalciRK(ka) {
    var bb = 0;
    var rk = 0;
    var a = new Uint8Array(4);
    var b = new Array(4);
    PUT_ULONG_BE(ka, a, 0);
    b[0] = sm4Sbox(a[0]);
    b[1] = sm4Sbox(a[1]);
    b[2] = sm4Sbox(a[2]);
    b[3] = sm4Sbox(a[3]);
    bb = GET_ULONG_BE(b, 0);

    rk = bb ^ (ROTL(bb, 13)) ^ (ROTL(bb, 23));

    return rk;
}

function sm4_setkey(SK, key) {
    var MK = new Array(4);
    var k = new Array(36);
    var i = 0;
    MK[0] = GET_ULONG_BE(key, 0);
    MK[1] = GET_ULONG_BE(key, 4);
    MK[2] = GET_ULONG_BE(key, 8);
    MK[3] = GET_ULONG_BE(key, 12);

    k[0] = MK[0] ^ FK[0];
    k[1] = MK[1] ^ FK[1];
    k[2] = MK[2] ^ FK[2];
    k[3] = MK[3] ^ FK[3];

    for (; i < 32; i++) {
        k[i + 4] = k[i] ^ (sm4CalciRK(k[i + 1] ^ k[i + 2] ^ k[i + 3] ^ CK[i]));
        SK[i] = k[i + 4];
    }
}

function sm4_one_round(sk, input, output) {
    var i = 0;
    var ulbuf = new Array(36);

    ulbuf[0] = GET_ULONG_BE(input, 0);
    ulbuf[1] = GET_ULONG_BE(input, 4);
    ulbuf[2] = GET_ULONG_BE(input, 8);
    ulbuf[3] = GET_ULONG_BE(input, 12);
    while (i < 32) {
        ulbuf[i + 4] = sm4F(ulbuf[i], ulbuf[i + 1], ulbuf[i + 2], ulbuf[i + 3], sk[i]);
        i++;
    }

    PUT_ULONG_BE(ulbuf[35], output, 0);
    PUT_ULONG_BE(ulbuf[34], output, 4);
    PUT_ULONG_BE(ulbuf[33], output, 8);
    PUT_ULONG_BE(ulbuf[32], output, 12);
}

/**
 *
 * @param {*} sk
 * @param {*} i
 */
function swap(sk, i) {
    let t = sk[i];
    sk[i] = sk[(31 - i)];
    sk[(31 - i)] = t;
}

function sm4_setkey_enc(ctx, key) {
    ctx.mode = SM4_ENCRYPT;
    sm4_setkey(ctx.sk, key);
}

function sm4_setkey_dec(ctx, key) {
    var i;
    ctx.mode = SM4_DECRYPT;
    sm4_setkey(ctx.sk, key);
    for (i = 0; i < 16; i++) {
        swap(ctx.sk, i);
    }
}

function sm4_crypt_ecb(ctx, input) {
    var index = 0;
    var length = input.length;
    var output = new Array();
    while (length > 0) {
        var oneInput = input.slice(index, index + 16)
        var oneOutput = new Uint8Array(16)
        sm4_one_round(ctx.sk, oneInput, oneOutput);

        for (var i = 0; i < 16; i++) {
            output[index + i] = oneOutput[i]
        }
        index += 16;
        length -= 16;
    }
    return output;
}

function sm4_crypt_cbc(ctx, mode, length, iv, input, output) {
    var i;
    var temp = new Array(16);
    var index = 0;

    if (mode == SM4_ENCRYPT) {
        while (length > 0) {
            var oneInput = input.slice(index, index + 16)
            var oneOutput = new Array(16)
            for (i = 0; i < 16; i++) {
                oneOutput[i] = oneInput[i] ^ iv[i]
            }

            sm4_one_round(ctx.sk, oneOutput, oneOutput);

            for (i = 0; i < 16; i++) {
                iv[i] = oneOutput[i]
                output[index + i] = oneOutput[i]
            }

            index += 16;
            length -= 16;
        }
    } else /* SM4_DECRYPT */ {
        while (length > 0) {
            var oneInput = input.slice(index, index + 16)
            var oneOutput = new Array(16)
            index += 16;
            for (i = 0; i < 16; i++) {
                temp[i] = oneInput[i]
            }

            sm4_one_round(ctx.sk, oneInput, oneOutput);

            for (i = 0; i < 16; i++) {
                oneOutput[i] = oneOutput[i] ^ iv[i]
                output[index + i] = oneOutput[i]
            }

            for (i = 0; i < 16; i++) {
                iv[i] = temp[i]
            }

            index += 16;
            length -= 16;
        }
    }
}

/**
 * Convert a hex string to a byte array 十六进制字符串转字节数组
 * @param {*} hex  hex string 十六进制字符串
 */
function hexToBytes(hex) {
    for (var bytes = [], c = 0; c < hex.length; c += 2)
        bytes.push(parseInt(hex.substr(c, 2), 16));
    return bytes;
}

/**
 * Convert a byte array to a hex string
 * @param {*} bytes byte array
 */
function bytesToHex(bytes) {
    for (var hex = [], i = 0; i < bytes.length; i++) {
        hex.push((bytes[i] >>> 4).toString(16));
        hex.push((bytes[i] & 0xF).toString(16));
    }
    return hex.join("");
}

/**
 * 字符串转为UTF-8编码字节数组
 * @param {*} str
 */
function strToBytes(str) {
    var bytes = new Array();
    var len, c;
    len = str.length;
    for (var i = 0; i < len; i++) {
        c = str.charCodeAt(i);
        if (c >= 0x010000 && c <= 0x10FFFF) {
            bytes.push(((c >> 18) & 0x07) | 0xF0);
            bytes.push(((c >> 12) & 0x3F) | 0x80);
            bytes.push(((c >> 6) & 0x3F) | 0x80);
            bytes.push((c & 0x3F) | 0x80);
        } else if (c >= 0x000800 && c <= 0x00FFFF) {
            bytes.push(((c >> 12) & 0x0F) | 0xE0);
            bytes.push(((c >> 6) & 0x3F) | 0x80);
            bytes.push((c & 0x3F) | 0x80);
        } else if (c >= 0x000080 && c <= 0x0007FF) {
            bytes.push(((c >> 6) & 0x1F) | 0xC0);
            bytes.push((c & 0x3F) | 0x80);
        } else {
            bytes.push(c & 0xFF);
        }
    }
    return bytes;
}


/**
 * 字节数组UTF-8转为字符串
 * @param {*} arr
 */
function bytesToString(arr) {
    if (typeof arr === 'string') {
        return arr;
    }
    var str = '',
        _arr = arr;
    for (var i = 0; i < _arr.length; i++) {
        var one = _arr[i].toString(2),
            v = one.match(/^1+?(?=0)/);
        if (v && one.length == 8) {
            var bytesLength = v[0].length;
            var store = _arr[i].toString(2).slice(7 - bytesLength);
            for (var st = 1; st < bytesLength; st++) {
                store += _arr[st + i].toString(2).slice(2);
            }
            str += String.fromCharCode(parseInt(store, 2));
            i += bytesLength - 1;
        } else {
            str += String.fromCharCode(_arr[i]);
        }
    }
    return str;
}


// base64 private property
var _keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";

/**
 * Base64编码 编码字节数组
 * @param {Array} input 字节数组
 */
function base64Encode(input) {

    // input = strToBytes(input);
    var output = "";
    var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
    var i = 0;

    while (i < input.length) {

        chr1 = input[i++];
        chr2 = input[i++];
        chr3 = input[i++];

        enc1 = chr1 >> 2;
        enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
        enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
        enc4 = chr3 & 63;

        if (isNaN(chr2)) {
            enc3 = enc4 = 64;
        } else if (isNaN(chr3)) {
            enc4 = 64;
        }

        output = output + _keyStr.charAt(enc1) + _keyStr.charAt(enc2) + _keyStr.charAt(enc3) + _keyStr.charAt(enc4);

    }

    return output;
}

/**
 * Base64解码 解码字符串为字节数组
 * @param {String} input 字符串
 */
function base64Decode(input) {
    var output = new Array();
    var chr1, chr2, chr3;
    var enc1, enc2, enc3, enc4;
    var i = 0;

    input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

    while (i < input.length) {

        enc1 = _keyStr.indexOf(input.charAt(i++));
        enc2 = _keyStr.indexOf(input.charAt(i++));
        enc3 = _keyStr.indexOf(input.charAt(i++));
        enc4 = _keyStr.indexOf(input.charAt(i++));

        chr1 = (enc1 << 2) | (enc2 >> 4);
        chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
        chr3 = ((enc3 & 3) << 6) | enc4;

        output.push(chr1);

        if (enc3 != 64) {
            output.push(chr2);
        }
        if (enc4 != 64) {
            output.push(chr3);
        }
    }

    return output;
}

/**
 * 确保传入密钥为16位字节字符串
 * @param {*} key
 */
function ensureKey(key) {
    if (!key) {
        // return x;
        return default_key;
    }
    key = key.replace(/[^\x00-\xff]/g, "00");
    var len = key.length;

    if (16 === len) {
        return key;
    }

    if (len > 16) {
        return key.substring(0, 16);
    }

    for (var i = 0; i < 16 - len; i++) {
        key = "0" + key;
    }
    return key;
}

/**
 * SM4 ECB模式加密
 * @param {*} plainText 明文
 * @param {*} key 密钥
 */
function encrypt_ECB(plainText, key) {

    var ctx = new sm4_context();
    ctx.mode = SM4_ENCRYPT;
    var keyBytes = strToBytes(ensureKey(key));
    sm4_setkey_enc(ctx, keyBytes);
    var encrypted = sm4_crypt_ecb(ctx, strToBytes(plainText));
    var cipherText = base64Encode(encrypted);

    return cipherText;
}

/**
 * SM4 ECB模式解密
 * @param {*} cipherText 密文
 * @param {*} key 密钥
 */
function decrypt_ECB(cipherText, key) {
    var ctx = new sm4_context();
    ctx.mode = SM4_DECRYPT;

    var keyBytes = strToBytes(ensureKey(key));
    sm4_setkey_dec(ctx, keyBytes);
    var encrypted = base64Decode(cipherText);
    var decrypted = sm4_crypt_ecb(ctx, encrypted);
    return bytesToString(decrypted);
}

//export {encrypt_ECB, decrypt_ECB}
// });
//})();
