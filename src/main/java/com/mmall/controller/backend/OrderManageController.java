package com.mmall.controller.backend;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IOrderService;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author YH
 */

@Controller
@RequestMapping("/manage/order/")
public class OrderManageController {
    @Autowired
    private  IOrderService iOrderService;
    @Autowired
    private IUserService iUserService;

    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse list(HttpSession session,
                               @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        //判断是否登录
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "");
        }

        //判断是否为管理员
        if(iUserService.checkAdminRole(user).isSuccess()){
            //是管理员 增加处理逻辑
            return iOrderService.manageList(pageNum, pageSize);

        }else{
            return ServerResponse.createByErrorMessage("无操作权限，需要管理员权限");
        }
    }

    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse detail(HttpSession session, long orderNo){
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        //判断是否登录
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "");
        }

        //判断是否为管理员
        if(iUserService.checkAdminRole(user).isSuccess()){
            //是管理员 增加处理逻辑
            return iOrderService.manageDetail(orderNo);

        }else{
            return ServerResponse.createByErrorMessage("无操作权限，需要管理员权限");
        }
    }

    @RequestMapping("search.do")
    @ResponseBody
    public ServerResponse orderSearch(HttpSession session, long orderNo,
                                      @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        //判断是否登录
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "");
        }

        //判断是否为管理员
        if(iUserService.checkAdminRole(user).isSuccess()){
            //是管理员 增加处理逻辑
            return iOrderService.manageSearch(orderNo, pageNum, pageSize);

        }else{
            return ServerResponse.createByErrorMessage("无操作权限，需要管理员权限");
        }
    }

    @RequestMapping("send_goods.do")
    @ResponseBody
    public ServerResponse<String> orderSendGoods(HttpSession session, long orderNo){
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        //判断是否登录
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "");
        }

        //判断是否为管理员
        if(iUserService.checkAdminRole(user).isSuccess()){
            //是管理员 增加处理逻辑
            return iOrderService.orderSendGoods(orderNo);

        }else{
            return ServerResponse.createByErrorMessage("无操作权限，需要管理员权限");
        }
    }

}
