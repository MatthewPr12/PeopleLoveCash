package org.example.decorator;


public class Main {
    public static void main(String[] args) {
        Document document = new SmartDocument("gs://my_oop/algo.png");
//        document = TimedDocument(document);
//        document = CashedDocument(document);
//        https://console.cloud.google.com/apis/dashboard?hl=uk&project=extended-inn-370706&show=all
//        https://cloud.google.com/sdk/auth_success
//        https://console.cloud.google.com/getting-started?project=extended-inn-370706
        System.out.println(document.parse());

    }
}
