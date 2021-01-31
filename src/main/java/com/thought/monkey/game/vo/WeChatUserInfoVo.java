package com.thought.monkey.game.vo;

import lombok.Data;

/**
 * @Auther: 杨伟栋
 * @Date: 2021/1/31 12:08
 * @Description: 1371690483@qq.com
 */
@Data
public class WeChatUserInfoVo {
    /*
     * @Author 杨伟栋
     * @Description
     * @Date 2021/1/31 12:08 下午
     * @Param
     * @return 微信返回的code
     **/
    private String code;
    /*
     * @Author 杨伟栋
     * @Description
     * @Date 2021/1/31 12:09 下午
     * @Param
     * @return 非敏感的用户信息
     **/
    private String rawData;

    /*
     * @Author 杨伟栋
     * @Description
     * @Date 2021/1/31 12:10 下午
     * @Param
     * @return 签名信息
     **/
    private String signature;

    /*
     * @Author 杨伟栋
     * @Description
     * @Date 2021/1/31 12:10 下午
     * @Param
     * @return 加密的数据
     **/
    private String encrypteData;

    /*
     * @Author 杨伟栋
     * @Description
     * @Date 2021/1/31 12:11 下午
     * @Param
     * @return 加密密钥
     **/
    private String iv;
}
