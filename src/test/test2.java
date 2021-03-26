package test;

import java.io.IOException;

public class test2 {
    public static void main(String[] args) throws IOException {
//        String imgUrl = "C:\\Users\\Tristanwu\\Desktop\\123.gif";
//        System.out.println(111);
//        System.out.println("data:image/" + imgUrl.substring(imgUrl.lastIndexOf(".") + 1) + ";base64,");
//        String a = "data:image/" + imgUrl.substring(imgUrl.lastIndexOf(".") + 1) + ";base64," + ImgBase64.getImgStr(imgUrl);
//        System.out.println(a);
        String ss = "[]";
        System.out.println(ss.substring(1, ss.length() - 1));
        String[] hours = ss.split(",");
        System.out.println(hours.length);
        StringBuilder hourTarget = new StringBuilder();
        for (String s : hours) {
            if (!s.equals("")) {
                if (s.length() == 1) {
                    hourTarget.append("0");
                }
                hourTarget.append(s).append(":00,");
            }
        }
        System.out.println(hourTarget.toString());
//        String base64 = ImgBase64.getImgStr(imgUrl);
//        System.out.println(base64);
//        System.out.println(base64.getBytes().length);
//        System.out.println(base64.length());
//        ImgBase64.generateImage(base64,"C:\\Users\\Tristanwu\\Desktop\\321.gif");
        // ImgBase64.download("https://img.lejuliang.com/dsp/2021/2/11614570544013.jpg");
    }
}