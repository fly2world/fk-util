package com.tmsps.fk.common.base.dto;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.tmsps.fk.common.util.ChkUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 蚂蚁金服的BaseQuery插件
 *
 * @author 398479251@qq.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class BaseVueQuery<T> extends BaseQuery<T> {

	private static final long serialVersionUID = 1L;

	private String sort;

	/**
	 * 调用 findAll时, 排序用一下
	 * 
	 * @return
	 */
	public OrderItem getOrderItem() {
		if (ChkUtil.isNotNull(sort)) {
			JSONArray sortArray = JSONArray.parseArray(sort);
			if (sortArray != null && sortArray.size() > 0) {
				JSONObject sorter = sortArray.getJSONObject(0);
				String porterty = sorter.getString("property");
				String direction = sorter.getString("direction");
				if ("asc".equals(direction)) {
					return OrderItem.asc(porterty);
				} else if ("desc".equals(direction)) {
					return OrderItem.desc(porterty);
				}
			}
		}
		return null;
	}

}
