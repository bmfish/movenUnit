package cbj.wc;


public  class DBUtil {

    public static void save(String sql) throws Exception {
        DBHelper db = new DBHelper(sql);
        try {
            db.pst.execute(sql);

        } catch (Exception e) {
            throw e;
        } finally {
            db.close();
        }

    }
}
