package com.server.tools.encryption;

public class RSATest {

    public static void main(String[] args) {
       RSAGenerator rsaGenerator = new RSAGenerator().generateKeyPair();
        String str="数表的质数又称素数。指整数在一个大于1的自然数中，除了1和此整数自身外，没法被其他自然数整除的数";
        String encode = rsaGenerator.encryptByPublic(str);
        System.out.println(encode);
        System.out.println(rsaGenerator.decryptByPrivate(encode));

        System.out.println("用私钥加密公钥解密");
        String encrypt = rsaGenerator.encryptByPrivate(str);
        System.out.println(encrypt);
        System.out.println(rsaGenerator.decryptByPublic(encrypt));

      /* String str = "1570227ea50bd47e75ae6853119b8e599908e596419c86f4b8cf365afe2fc0dc95dd0521f216483da5eb4b9d8f5d8b99d062a4849f3f3b1e06174d0758ec69d1205612dc57b716291c8889e8a64b7c7dff8fa98f1f2e8c32be6f38c4bc0fe3dd3934feb1dbcc3f4cce6342ed55551143dbcbc608670f593ce48cf5e92085a692d695e5f491150bd680e776465f27d60608ac63a055aff466d881ec320907c9c927cc0c7edcacc8ac2ca44d71ad698aea742cf076add89fbe9ac12d4ac67ea3b19393a1874d2ba2312f89f75aedb82b8f0bd606bbbaa86483b144ca2a9536244394ff471720996a7e162b5c32b7d023302bb46a924d3b1f6d9ff1302bcc7699a8";
       System.out.println(str.length());*/

        //从BASE64文件中读取KEY值
        /*RSAGenerator rsaGenerator = new RSAGenerator();
        rsaGenerator.getKeyFromBase64File("private.txt", RSAGenerator.KEY_TYPE_PRIVATE);
        rsaGenerator.getKeyFromBase64File("public.txt", RSAGenerator.KEY_TYPE_PUBLIC);
        String str="数表的质数又称素数。指整数在一个大于1的自然数中，除了1和此整数自身外，没法被其他自然数整除的数";
        String encode = rsaGenerator.encryptByPublic(str);
        System.out.println(encode);
        System.out.println(rsaGenerator.decryptByPrivate(encode));*/
    }
}