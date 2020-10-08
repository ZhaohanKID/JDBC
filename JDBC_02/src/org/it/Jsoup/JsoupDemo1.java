package org.it.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/5 15:46
 */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        // 2 获取Document对象，根据xml文档获取
        // 2.1 获取student.xml的Path
        String path = JsoupDemo1.class.getClassLoader().getResource("users.xml").getPath();
        // 2.2 解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        // user
        Elements elements = document.getElementsByTag("user");
        System.out.println(elements);

        System.out.println("------------------");

        // 获取属性名为number的元素对象们
        Elements elements1 = document.getElementsByAttribute("number");
        System.out.println(elements1);
        System.out.println("------------------");

        // 获取id属性值为001的元素对象
        Elements elements2 = document.getElementsByAttributeValue("id", "001");
        System.out.println(elements2);
        System.out.println("------------------");

        // 获取id属性值的元素对象
        Element element = document.getElementById("002");
        System.out.println(element);





     /*   // 3 获取元素对象 Element
        Elements elements = document.getElementsByTag("name");

        System.out.println(elements.size());
        // 获取第一个Element的element对象
        Element element = elements.get(0);
        String name = element.text();
        System.out.println(name);*/
    }
}
