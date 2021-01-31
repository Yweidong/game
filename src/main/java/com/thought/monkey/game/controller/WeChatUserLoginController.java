package com.thought.monkey.game.controller;

import com.alibaba.fastjson.JSONObject;
import com.thought.monkey.game.util.WeChatUtil;
import com.thought.monkey.game.vo.WeChatUserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 杨伟栋
 * @Date: 2021/1/31 12:28
 * @Description: 1371690483@qq.com
 */
@RestController
@RequestMapping("wx")
@Slf4j
public class WeChatUserLoginController {

    @PostMapping("/login")
    public void user_login(@RequestBody WeChatUserInfoVo weChatUserInfoVo) {
        //登录凭证校验接口 appId + appSecret + 接收小程序发送的code
        JSONObject jsonObject = WeChatUtil.getSessionKeyOrOpenId(weChatUserInfoVo.getCode());

        //接收微信接口服务 获取返回的参数
        String opernid = jsonObject.getString("opernid");
        String session_key = jsonObject.getString("session_key");
        // 用户非敏感信息：rawData
        // 签名：signature
        JSONObject rawDataJson = JSONObject.parseObject(weChatUserInfoVo.getRawData());
        //encrypteData比rowData多了appid和openid
        JSONObject userInfo = WeChatUtil.getUserInfo(weChatUserInfoVo.getEncrypteData(),
                session_key, weChatUserInfoVo.getIv());
        log.info("userInfo ---"+userInfo.toString());
        log.info("rawDataJson----"+rawDataJson);



    }
}
