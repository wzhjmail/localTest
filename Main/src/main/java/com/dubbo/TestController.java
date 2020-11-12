package com.dubbo;

import com.aop.Action;
import com.common.HttpclientUtils;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/** @ClassName TestController @Description @Author wzj @Date 2020/8/3 19:36 */
@RequestMapping("/dubbo")
@Controller
public class TestController {

//  @Autowired
//  private ContractApi contractApi;

  @RequestMapping("/test")
  @ResponseBody
  @Action(name = "注解式拦截-----")
  public String test() throws Exception {
    List<String> lists = new ArrayList<>();
    lists.add("1");
    lists.add("2");
    lists.add("2020080400001a");
//    BasicIdsReqDto basicIdsReqDto = new BasicIdsReqDto();
//    basicIdsReqDto.setPageNumber(0);
//    basicIdsReqDto.setPageSize(10);
//    List<Long> list = new ArrayList<>();
//    list.add(1007930L);
//    basicIdsReqDto.setBasicIds(list);
    //Page<ContractResDto> app = contractApi.getContractListByBasicIds(basicIdsReqDto);
    //List<AppointGroupInfo> app = appointInfoApi.getGroupMessage(lists);
    return "123456";
  }

  @RequestMapping("con")
  @ResponseBody
  public String con() throws Exception{
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("id","228");
    jsonObject.addProperty("opUser","zhangsan");
    jsonObject.addProperty("system","dmall");

    String resp = HttpclientUtils.postJsonWithTimeOut("http://192.168.253.103:9129" + "/ecp/api/v2/contract/temp/get", jsonObject.toString(), 2000);
    System.out.println(resp);
    return resp;
  }

  @RequestMapping("par")
  @ResponseBody
  public String par(@RequestBody Par par){
    System.out.println(par.toString());
    return par.toString();
  }

  public static void main(String[] args) {

  }
}
