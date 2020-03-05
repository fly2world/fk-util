package org.fxd.fk.common.util.poi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;

/**
 * poi操作工具类
 * @author 张晓明
 *
 * @dateTime  2019年11月21日 下午3:58:45
 *
 */
public class ExcelUtil {
	
	/**
	 *  导出模板
	 * @param title 标题名
	 * @param headers 列名
	 */
	public static Workbook genTemplate(String title,List<ExcelExportEntity> entityList) {
		return genTemplate(null, title, entityList);
	}
	
	/**
	 * 导出模板
	 * @param sheet 
	 * @param title 标题名
	 * @param headers 列名
	 */
	public static Workbook genTemplate(String sheet,String title,List<ExcelExportEntity> entityList) {
		return ExcelExportUtil.exportExcel(new ExportParams(title, sheet == null? "sheet":sheet), entityList, new ArrayList<Map<String, Object>>());
	}
	
	
	/**
	 *  excel导入
	 * @param file
	 * @param params
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static List<Map<String, Object>> importExcel(MultipartFile file,ImportParams params) throws IOException, Exception{
		return ExcelImportUtil.importExcel(file.getInputStream(), Map.class, params);
	}
	
	/**
	 * 
	 * @param file
	 * @param pojoClass
	 * @param params
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static List<?> importExcel(MultipartFile file,Class<?> pojoClass,ImportParams params) throws IOException, Exception{
		return ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
	}
	
	/**
	 *  根据实体导出
	 * @param pojoClass
	 * @param params
	 * @param dataList
	 * @return
	 */
	public static Workbook exportExcel(Class<?> pojoClass,ExportParams params,List<?> dataList) {
		return ExcelExportUtil.exportExcel(params, pojoClass, dataList);
	}
	
	/**
	 * 根据map导出  --自定义
	 * @param params
	 * @param entityList
	 * @param dataList
	 * @return
	 */
	public static Workbook exportExcel(ExportParams params,List<ExcelExportEntity> entityList,List<Map<String,Object>> dataList) {
		return ExcelExportUtil.exportExcel(params, entityList, dataList);
	}

}
