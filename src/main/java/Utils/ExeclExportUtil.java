package Utils;

import POJO.User;
import org.apache.poi.hssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

public class ExeclExportUtil {
    public  <T> void export(String[] titles, List<T> list ,Class<T> zclass, ServletOutputStream out) {
        try {   // 第一步，创建一个workbook，对应一个Excel文件

            // clazz = Person.class;
            HSSFWorkbook workbook = new HSSFWorkbook();

            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet hssfSheet = workbook.createSheet("sheet1");

            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short

            HSSFRow row = hssfSheet.createRow(0);
            // 第四步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle hssfCellStyle = workbook.createCellStyle();

            //居中样式
            hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

            HSSFCell hssfCell = null;
            for (int i = 0; i < titles.length; i++) {
                hssfCell = row.createCell(i);//列索引从0开始
                hssfCell.setCellValue(titles[i]);//列名1
                hssfCell.setCellStyle(hssfCellStyle);//列居中显示
            }

            // 第五步，写入实体数据
            // list 通过调度接口的时候提供
            int t=0;
            for (Object obj:list
            ) {
                row = hssfSheet.createRow(t + 1);
                t++;
                Class cls=obj.getClass();//得到泛型的实体类

                //2.返回字段的数组
                Field[] fields = cls.getDeclaredFields();//得到实体类字段属性名
                //对字段属性名进行遍历
                for (int i=0;i<fields.length;i++){
                    Field f=fields[i];//获得单前的属性名对象

                    System.out.println(f);
                }



            }

            // 第七步，将文件输出到客户端浏览器
            try {
                workbook.write(out);
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch(
                Exception e)

        {
            e.printStackTrace();
        }
    }
}
