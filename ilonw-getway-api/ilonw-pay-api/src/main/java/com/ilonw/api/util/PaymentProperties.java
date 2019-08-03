package com.ilonw.api.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentProperties {
    /**
     * 支付宝支付参数
     */
    @Value("${alipay.charset}")
    public String alipayCharset;
    @Value("${alipay.appid}")
    public String alipayAppid;
    @Value("${alipay.appprivatekey}")
    public String alipayAppprivatekey;
    @Value("${alipay.publickey}")
    public String alipayPublickey;
    @Value("${alipay.notifyurl}")
    public String alipayNotifyurl;
    @Value("${alipay.gateway}")
    public String alipayGateway;

    /**
     * 微信支付参数
     */
    @Value("${wechatpay.appId}")
    public String wechatpayAppId;
    @Value("${wechatpay.secretkey}")
    public String wechatpaySecretkey;
    @Value("${wechatpay.mchId}")
    public String wechatpayMchId;
    @Value("${wechatpay.mchKey}")
    public String wechatpayMchKey;
    @Value("${wechatpay.withdraw}")
    public String wechatpayWithdraw;
    @Value("${wechatpay.notifyUrl}")
    public String wecharpayNotifyUrl;
}
