package org.example.decorator;


public class CachedDocument implements Document{
    private String gcsPath;
    private Connection connection;

    public CachedDocument(String gcsPath) {
        this.gcsPath = gcsPath;
        connection = Connection.getInstance();
    }


    @Override
    public String parse() {
        String res = connection.searchQuery("SELECT * from cachedDoc WHERE gcsPath = '"  + gcsPath + "'");
        if(res!=null){
//            System.out.println(res);
            return res;
        }else{
            SmartDocument smartDocument = new SmartDocument(gcsPath);
            String text = smartDocument.parse();
            String sql = "INSERT INTO cachedDoc values ('" + gcsPath + "', '" + text + "')";
            connection.executeQuery(sql);
//            System.out.println(text);
            return text;
        }
    }
}
