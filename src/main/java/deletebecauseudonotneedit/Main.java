package deletebecauseudonotneedit;

import java.util.logging.Logger;


class Page {
    public String name;
}

class Registry {
    public boolean deleteReference(String name) {
        return true;
    }
}

class ConfigKeys {
    public boolean deleteKey(String name) {
        return true;
    }
}

class Processor {
    private Registry registry = new Registry();
    private ConfigKeys configKeys = new ConfigKeys();
    private final Logger logger = Logger.getLogger(Processor.class.getName());

    private boolean deletePage(Page page) {
        return true;
    }

    public int delete(Page page) {
        if (deletePage(page)) {
            if (registry.deleteReference(page.name)) {
                if (configKeys.deleteKey(page.name)) {
                    logger.info("page deleted");
                } else {
                    logger.info("configKey not deleted");
                }
                return 1;
            } else {
                logger.info("deleteReference from registry failed");
                return 1;
            }
        }
        logger.info("delete failed");
        return 2;
    }
}


public class Main {
    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%4$s %2$s %5$s%6$s%n");
        Page mypage = new Page();
        mypage.name = "Some Info";
        Processor myprocessor = new Processor();
        myprocessor.delete(mypage);
    }
}