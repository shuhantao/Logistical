package express.model;
public class GetXml {
    public static final String ATTRIBUTE_NAMES[][] = { { "发站", "到站" }, { "发货人", "发货人电话" }, { "收货人", "收货人电话" },
            { "付款方式", "品类", "小类", "件数", "单价", "已付", "提付", "月结" }, { "代收款", "返款方", "从", "到", "保价费", "接货费", "送运费" },
            { "总件数", "总运费" } };
    public static final String ATTRIBUTE_VALUES[][] = { { "Fstation", "Tstation" }, { "Fname", "Ftel" },
            { "Tname", "Ttel" },
            { "payWay", "category1", "category2", "number", "uniprice", "HavePay", "ToPay", "MonthPay" },
            { "daishou", "fankuan", "Fbaojia", "Tbaojia", "baojia", "jiehuo", "songyun" }, { "totnumber", "totpay" } };
    public static final String INFO[] = { "基本信息", "发货人信息", "收货人信息", "货物信息", "价格信息", "合计信息" };
    public static final int list[][] = { { 0, 1 }, null, null, { 0, 1, 2, }, { 2, 3 }, null };

    public static void main(String args[]) {
        for (int i = 0; i < INFO.length; i++) {
            printCg(i);
            for (int j = 0; j < ATTRIBUTE_NAMES[i].length; j++) {
                Boolean flag = false;
                if (list[i] != null) {
                    for (int k = 0; k < list[i].length; k++) {
                        if (list[i][k] == j)
                            flag = true;
                    }
                }
                if (flag)
                    printList(i, j);
                else
                    printEdit(i, j);
                if (i == 4)
                    j++;
            }

        }
    }

    public static void printList(int i, int j) {
        if (i == 4) {
            System.out.println("<LinearLayout\r\n" +

                    "android:layout_width=\"match_parent\"\n" + "android:layout_height=\"wrap_content\"\n"
                    + "android:orientation=\"horizontal\">\n");
            System.out.println("<LinearLayout\r\n" + "            android:layout_width=\"wrap_content\"\r\n"
                    + "            android:layout_height=\"wrap_content\"\r\n"
                    + "            android:orientation=\"horizontal\">\r\n" + "            <TextView\r\n"
                    + "                android:layout_width=\"wrap_content\"\r\n"
                    + "                android:layout_height=\"wrap_content\"\r\n"
                    + "                android:layout_weight=\"1\"\r\n" + "                android:text=\""
                    + ATTRIBUTE_NAMES[i][j] + "\"/>\r\n" + "            <Spinner\r\n"
                    + "                android:id=\"@+id/" + ATTRIBUTE_VALUES[i][j] + "\"\r\n"
                    + "                android:layout_width=\"match_parent\"\r\n"
                    + "                android:layout_height=\"wrap_content\"\r\n"
                    + "                android:layout_weight=\"1\">\r\n" + "\r\n" + "            </Spinner>\r\n"
                    + "        </LinearLayout>");
            if(j+1<ATTRIBUTE_NAMES[i].length)
                System.out.println("<LinearLayout\r\n" + "            android:layout_width=\"wrap_content\"\r\n"
                        + "            android:layout_height=\"wrap_content\"\r\n"
                        + "            android:orientation=\"horizontal\">\r\n" + "            <TextView\r\n"
                        + "                android:layout_width=\"wrap_content\"\r\n"
                        + "                android:layout_height=\"wrap_content\"\r\n"
                        + "                android:layout_weight=\"1\"\r\n" + "                android:text=\""
                        + ATTRIBUTE_NAMES[i][j + 1] + "\"/>\r\n" + "            <Spinner\r\n"
                        + "                android:id=\"@+id/" + ATTRIBUTE_VALUES[i][j + 1] + "\"\r\n"
                        + "                android:layout_width=\"match_parent\"\r\n"
                        + "                android:layout_height=\"wrap_content\"\r\n"
                        + "                android:layout_weight=\"1\">\r\n" + "\r\n" + "            </Spinner>\r\n"
                        + "        </LinearLayout>");
            System.out.println("</LinearLayout>\r\n");
        } else {
            System.out.println("<LinearLayout\r\n" + "            android:layout_width=\"wrap_content\"\r\n"
                    + "            android:layout_height=\"wrap_content\"\r\n"
                    + "            android:orientation=\"horizontal\">\r\n" + "            <TextView\r\n"
                    + "                android:layout_width=\"wrap_content\"\r\n"
                    + "                android:layout_height=\"wrap_content\"\r\n"
                    + "                android:layout_weight=\"1\"\r\n" + "                android:text=\""
                    + ATTRIBUTE_NAMES[i][j] + "\"/>\r\n" + "            <Spinner\r\n"
                    + "                android:id=\"@+id/" + ATTRIBUTE_VALUES[i][j] + "\"\r\n"
                    + "                android:layout_width=\"match_parent\"\r\n"
                    + "                android:layout_height=\"wrap_content\"\r\n"
                    + "                android:layout_weight=\"1\">\r\n" + "\r\n" + "            </Spinner>\r\n"
                    + "        </LinearLayout>");
        }
    }

    public static void printCg(int i) {
        System.out.println("<TextView\n" + "android:layout_width=\"match_parent\"\n"
                + "android:layout_height=\"wrap_content\"\n" + "android:text=\"" + INFO[i] + "\"/>\n");
        System.out.println(" <LinearLayout style=\"@style/common_horizontal_division_line_style\"></LinearLayout>");
    }

    public static void printEdit(int i, int j) {
        if (i == 4 && j % 2 == 0) {
            System.out.println("<LinearLayout\r\n" +

                    "android:layout_width=\"match_parent\"\n" + "android:layout_height=\"wrap_content\"\n"
                    + "android:orientation=\"horizontal\">\n");
            System.out.println(" <com.wrapp.floatlabelededittext.FloatLabeledEditText\n"
                    + "android:layout_width=\"wrap_content\"\r\n"
                    + "android:layout_weight=\"1\"\n"
                    + "android:layout_height=\"wrap_content\">\n" + "<EditText\n"
                    + "android:id=\"@+id/" + ATTRIBUTE_VALUES[i][j] + "\"\n"
                    + "android:layout_width=\"match_parent\"\n" + "android:layout_height=\"wrap_content\"\n"
                    + "android:singleLine=\"true\"\n" + "android:hint=\"" + ATTRIBUTE_NAMES[i][j] + "\"/>\n"
                    + "</com.wrapp.floatlabelededittext.FloatLabeledEditText>\n");
            if(j+1<ATTRIBUTE_NAMES[i].length)
                System.out.println(" <com.wrapp.floatlabelededittext.FloatLabeledEditText\n"
                        + "android:layout_width=\"wrap_content\"\r\n"
                        + "android:layout_weight=\"1\"\n"
                        + "android:layout_height=\"wrap_content\">\n" + "<EditText\n"
                        + "android:id=\"@+id/" + ATTRIBUTE_VALUES[i][j+1] + "\"\n"
                        + "android:layout_width=\"match_parent\"\n" + "android:layout_height=\"wrap_content\"\n"
                        + "android:singleLine=\"true\"\n" + "android:hint=\"" + ATTRIBUTE_NAMES[i][j+1] + "\"/>\n"
                        + "</com.wrapp.floatlabelededittext.FloatLabeledEditText>\n");
            System.out.println("</LinearLayout>\r\n");
        } else {
            System.out.println(" <com.wrapp.floatlabelededittext.FloatLabeledEditText\n"
                    + "android:layout_width=\"match_parent\"\n" + "android:layout_height=\"wrap_content\">\n"
                    + "<EditText\n" + "android:id=\"@+id/" + ATTRIBUTE_VALUES[i][j] + "\"\n"
                    + "android:layout_width=\"match_parent\"\n" + "android:layout_height=\"wrap_content\"\n"
                    + "android:singleLine=\"true\"\n" + "android:hint=\"" + ATTRIBUTE_NAMES[i][j] + "\"/>\n"
                    + "</com.wrapp.floatlabelededittext.FloatLabeledEditText>\n");
        }
    }
}
