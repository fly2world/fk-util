package org.fxd.fk.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TreeTools {

	// 预处理地区树节点
	public static List<Map<String, Object>> ListToTree_area(List<Map<String, Object>> menuList, boolean isChecked) {
		for (Map<String, Object> map : menuList) {
			map.put("id", map.get("code"));
			map.put("text", map.get("project_name"));
			map.put("leaf", true);
			if (isChecked) {
				map.put("checked", false);
			}
		}
		return menuList;
	}

	public static String IndexMListToTree_area(List<Map<String, Object>> menuList) {
		// 转换List为树形结构
		return indexMListToTree_area(menuList, false);
	}

	@SuppressWarnings("unchecked")
	public static String indexMListToTree_area(List<Map<String, Object>> menuList, boolean isChecked) {
		// 转换List为树形结构
		menuList = ListToTree_area(menuList, isChecked);

		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> node1 : menuList) {
			String node1_code = (String) node1.get("code");
			String node1_parent_code = node1_code.substring(0, node1_code.length() - 3);

			boolean mark = false;
			for (Map<String, Object> node2 : menuList) {
				String node2_code = (String) node2.get("code");

				if (node1_parent_code != null && node1_parent_code.equals(node2_code)) {
					mark = true;
					if (node2.get("children") == null) {
						node2.put("children", new ArrayList<Map<String, Object>>());
					}
					((List<Map<String, Object>>) node2.get("children")).add(node1);
					node2.put("leaf", false);
					if (!isChecked) {
						node2.put("expanded", false);
					}
					break;
				}
			}
			if (!mark) {
				nodeList.add(node1);
			}
		}
		return JsonUtil.toJson(nodeList);
	}

	// 预处理系统树节点
	public static List<Map<String, Object>> handleTree(List<Map<String, Object>> menuslist) {
		return handleTree_sys(menuslist, false);
	}

	public static List<Map<String, Object>> handleTree_sys(List<Map<String, Object>> menuslist, boolean isChecked) {

		for (Map<String, Object> map : menuslist) {
			map.put("text", map.get("menu_name"));
			map.put("id", map.get("menu_code"));
			map.put("leaf", true);
			map.put("checked", isChecked);
		}
		return menuslist;
	}

	public static List<Map<String, Object>> handle_sys(List<Map<String, Object>> menuslist, boolean isChecked) {

		for (Map<String, Object> map : menuslist) {
			map.put("text", map.get("name"));
			map.put("id", map.get("code"));
			map.put("leaf", true);
			if (isChecked) {
				map.put("checked", false);
			}
		}
		return menuslist;
	}

	public static List<Map<String, Object>> handle_sysNo(List<Map<String, Object>> menuslist, boolean isChecked) {

		for (Map<String, Object> map : menuslist) {
			map.put("text", map.get("menu_name"));
			map.put("id", map.get("menu_code"));
			map.put("leaf", true);
		}
		return menuslist;
	}

	// 预处理机构树节点
	public static List<Map<String, Object>> handleTree_bank(List<Map<String, Object>> menuList) {
		return handleTree_bank(menuList, false);
	}

	public static List<Map<String, Object>> handleTree_bank(List<Map<String, Object>> menuList, boolean isChecked) {
		for (Map<String, Object> map : menuList) {
			map.put("id", map.get("dept_code"));
			map.put("iconCls", map.get("url"));
			map.put("text", map.get("bank_name"));
			map.put("leaf", true);
			if (isChecked) {
				map.put("checked", false);
			}
		}

		return menuList;
	}

	// 预处理地区树节点
	public static List<Map<String, Object>> handleTree_area(List<Map<String, Object>> menuList) {
		return handleTree_area(menuList, false);
	}

	// 预处理地区树节点
	public static List<Map<String, Object>> handleTree_area(List<Map<String, Object>> menuList, boolean isChecked) {
		for (Map<String, Object> map : menuList) {
			map.put("id", map.get("project_id"));
			map.put("text", map.get("PROJECT_NAME"));
			map.put("leaf", true);
			if (isChecked) {
				map.put("checked", false);
			}
		}

		return menuList;
	}

	// 系统数据源整理成树结构
	public static String sysMenusTreeNo(List<Map<String, Object>> menuList) {
		// 转换List为树形结构
		return sysMenusTreeNo(menuList, false);
	}

	@SuppressWarnings("unchecked")
	public static String sysMenusTreeNo(List<Map<String, Object>> menuList, boolean isChecked) {
		// 转换List为树形结构
		menuList = handle_sysNo(menuList, isChecked);

		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> node1 : menuList) {

			String node1_code = (String) node1.get("menu_code");
			String node1_parent_code = node1_code.substring(0, node1_code.length() - 3);
			boolean mark = false;
			for (Map<String, Object> node2 : menuList) {
				String node2_code = (String) node2.get("menu_code");

				if (node1_parent_code != null && node1_parent_code.equals(node2_code)) {
					mark = true;
					if (node2.get("children") == null) {
						node2.put("children", new ArrayList<Map<String, Object>>());
					}
					((List<Map<String, Object>>) node2.get("children")).add(node1);
					node2.put("leaf", false);
					if (!isChecked) {
						node2.put("expanded", false);
					}
					break;
				}
			}
			if (!mark) {
				nodeList.add(node1);
			}
		}
		return JsonUtil.toJson(nodeList);
	}

	// 系统数据源整理成树结构
	public static String sysMenusTree(List<Map<String, Object>> menuList) {
		// 转换List为树形结构
		return sysMenusTree(menuList, false);
	}

	@SuppressWarnings("unchecked")
	public static String sysMenusTree(List<Map<String, Object>> menuList, boolean isChecked) {
		// 转换List为树形结构
		menuList = handleTree_sys(menuList, isChecked);
		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> node1 : menuList) {

			String node1_code = (String) node1.get("menu_code");
			String node1_parent_code = node1_code.substring(0, node1_code.length() - 3);
			boolean mark = false;
			for (Map<String, Object> node2 : menuList) {
				String node2_code = (String) node2.get("menu_code");

				if (node1_parent_code != null && node1_parent_code.equals(node2_code)) {
					mark = true;
					if (node2.get("children") == null) {
						node2.put("children", new ArrayList<Map<String, Object>>());
					}
					((List<Map<String, Object>>) node2.get("children")).add(node1);
					node2.put("leaf", false);
					if (!isChecked) {
						node2.put("expanded", false);
					}
					break;
				}
			}
			if (!mark) {
				nodeList.add(node1);
			}
		}
		return JsonUtil.toJson(nodeList);
	}

	// 机构数整理成树结构
	public static String turnListToTree_bank(List<Map<String, Object>> menuList) {
		// 转换List为树形结构
		return turnListToTree_bank(menuList, false);
	}

	@SuppressWarnings("unchecked")
	public static String turnListToTree_bank(List<Map<String, Object>> menuList, boolean isChecked) {
		// 转换List为树形结构
		menuList = handleTree_bank(menuList, isChecked);

		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> node1 : menuList) {
			String node1_code = (String) node1.get("dept_code");
			String node1_parent_code = node1_code.substring(0, node1_code.length() - 3);

			boolean mark = false;
			for (Map<String, Object> node2 : menuList) {
				String node2_code = (String) node2.get("dept_code");

				if (node1_parent_code != null && node1_parent_code.equals(node2_code)) {
					mark = true;
					if (node2.get("children") == null) {
						node2.put("children", new ArrayList<Map<String, Object>>());
					}
					((List<Map<String, Object>>) node2.get("children")).add(node1);
					node2.put("leaf", false);
					if (!isChecked) {
						node2.put("expanded", true);
					}
					break;
				}
			}
			if (!mark) {
				nodeList.add(node1);
			}
		}
		return JsonUtil.toJson(nodeList);
	}

	public static String turnListToTree_area(List<Map<String, Object>> menuList) {
		// 转换List为树形结构
		return turnListToTree_area(menuList, false);
	}

	@SuppressWarnings("unchecked")
	public static String turnListToTree_area(List<Map<String, Object>> menuList, boolean isChecked) {
		// 转换List为树形结构
		menuList = handleTree_area(menuList, isChecked);

		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> node1 : menuList) {
			String node1_code = (String) node1.get("code");
			String node1_parent_code = node1_code.substring(0, node1_code.length() - 3);

			boolean mark = false;
			for (Map<String, Object> node2 : menuList) {
				String node2_code = (String) node2.get("code");

				if (node1_parent_code != null && node1_parent_code.equals(node2_code)) {
					mark = true;
					if (node2.get("children") == null) {
						node2.put("children", new ArrayList<Map<String, Object>>());
					}
					((List<Map<String, Object>>) node2.get("children")).add(node1);
					node2.put("leaf", false);
					if (!isChecked) {
						node2.put("expanded", false);
					}
					break;
				}
			}
			if (!mark) {
				nodeList.add(node1);
			}
		}
		return JsonUtil.toJson(nodeList);
	}

	// 预处理树节点
	public static List<Map<String, Object>> handleAreaTree(List<Map<String, Object>> menuList, boolean isChecked,
			int deep) {
		for (Map<String, Object> map : menuList) {
			map.put("id", map.remove("code"));
			map.put("iconCls", map.remove("area_id"));
			map.put("text", map.remove("area_name"));
			if (deep == 3) {
				map.put("leaf", true);

			} else {
				map.put("leaf", false);
			}

			if (isChecked) {
				map.put("checked", false);
			}
		}
		return menuList;
	}

	// 系统数据源整理成树结构
	public static String sysParamTreeNo(List<Map<String, Object>> menuList) {
		// 转换List为树形结构
		return sysParamTreeNo(menuList, false);
	}

	@SuppressWarnings("unchecked")
	public static String sysParamTreeNo(List<Map<String, Object>> menuList, boolean isChecked) {
		// 转换List为树形结构
		menuList = handle_paramNo(menuList, isChecked);

		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> node1 : menuList) {

			String node1_code = (String) node1.get("param_code");
			String node1_parent_code = node1_code.substring(0, node1_code.length() - 3);
			boolean mark = false;
			for (Map<String, Object> node2 : menuList) {
				String node2_code = (String) node2.get("param_code");

				if (node1_parent_code != null && node1_parent_code.equals(node2_code)) {
					mark = true;
					if (node2.get("children") == null) {
						node2.put("children", new ArrayList<Map<String, Object>>());
					}
					((List<Map<String, Object>>) node2.get("children")).add(node1);
					node2.put("leaf", false);
					if (!isChecked) {
						node2.put("expanded", false);
					}
					break;
				}
			}
			if (!mark) {
				nodeList.add(node1);
			}
		}
		return JsonUtil.toJson(nodeList);
	}

	public static List<Map<String, Object>> handle_paramNo(List<Map<String, Object>> menuslist, boolean isChecked) {

		for (Map<String, Object> map : menuslist) {
			// String a = map.get("status").toString();
			// if("0".equals(a)) {
			map.put("text", map.get("param_name"));
			map.put("id", map.get("param_code"));
			map.put("leaf", true);
			if (isChecked) {
				map.put("checked", false);
				// }
			}
		}
		return menuslist;
	}

	// 机构添加参数
	// 机构数整理成树结构
	public static String turnListToTree_bankAdd(List<Map<String, Object>> menuList) {
		// 转换List为树形结构
		return turnListToTree_bankAdd(menuList, false);
	}

	@SuppressWarnings("unchecked")
	public static String turnListToTree_bankAdd(List<Map<String, Object>> menuList, boolean isChecked) {
		// 转换List为树形结构
		menuList = handleTree_bankAdd(menuList, isChecked);

		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> node1 : menuList) {
			String node1_code = (String) node1.get("dept_code");
			String node1_parent_code = node1_code.substring(0, node1_code.length() - 3);

			boolean mark = false;
			for (Map<String, Object> node2 : menuList) {
				String node2_code = (String) node2.get("dept_code");
				String bank_id = (String) node2.get("bank_id");

				if (node1_parent_code != null && node1_parent_code.equals(node2_code)) {
					mark = true;
					if (node2.get("children") == null) {
						node2.put("children", new ArrayList<Map<String, Object>>());
					}
					((List<Map<String, Object>>) node2.get("children")).add(node1);
					node2.put("leaf", false);
					if (!isChecked) {
						node2.put("expanded", false);
					}
					break;
				}
			}
			if (!mark) {
				nodeList.add(node1);
			}
		}
		return JsonUtil.toJson(nodeList);
	}

	public static List<Map<String, Object>> handleTree_bankAdd(List<Map<String, Object>> menuList, boolean isChecked) {
		for (Map<String, Object> map : menuList) {
			map.put("id", map.get("bank_id"));
			map.put("iconCls", map.get("url"));
			map.put("text", map.get("bank_name"));
			map.put("leaf", true);
			if (isChecked) {
				map.put("checked", false);
			}
		}

		return menuList;
	}

	public static List<Map<String, Object>> bankSys_tree(List<Map<String, Object>> menuslist, boolean isChecked) {

		for (Map<String, Object> map : menuslist) {
			map.put("text", map.get("menu_name"));
			map.put("id", map.get("menus_code"));
			map.put("id", map.get("menu_code"));
			map.put("iconCls", map.get("icon"));
			map.put("leaf", true);
			map.put("checked", isChecked);
		}
		return menuslist;
	}

	@SuppressWarnings("unchecked")
	public static String bankSys(List<Map<String, Object>> menuList, boolean isChecked) {
		// 转换List为树形结构
		menuList = bankSys_tree(menuList, isChecked);
		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> node1 : menuList) {

			String node1_code = (String) node1.get("menu_code");
			String node1_parent_code = node1_code.substring(0, node1_code.length() - 3);
			boolean mark = false;
			for (Map<String, Object> node2 : menuList) {
				String node2_code = (String) node2.get("menu_code");

				if (node1_parent_code != null && node1_parent_code.equals(node2_code)) {
					mark = true;
					if (node2.get("children") == null) {
						node2.put("children", new ArrayList<Map<String, Object>>());
					}
					((List<Map<String, Object>>) node2.get("children")).add(node1);
					node2.put("leaf", false);
					if (!isChecked) {
						node2.put("expanded", false);
					}
					break;
				}
			}
			if (!mark) {
				nodeList.add(node1);
			}
		}
		return JsonUtil.toJson(nodeList);
	}

	// 机构添加参数
	// 机构数整理成树结构
	public static String turnListToTree_userAdd(List<Map<String, Object>> menuList) {
		// 转换List为树形结构
		return turnListToTree_userAdd(menuList, false);
	}

	@SuppressWarnings("unchecked")
	public static String turnListToTree_userAdd(List<Map<String, Object>> menuList, boolean isChecked) {
		// 转换List为树形结构
		menuList = handleTree_userAdd(menuList, isChecked);

		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> node1 : menuList) {
			String node1_code = (String) node1.get("dept_code");
			String node1_parent_code = node1_code.substring(0, node1_code.length() - 3);

			boolean mark = false;
			for (Map<String, Object> node2 : menuList) {
				String node2_code = (String) node2.get("dept_code");

				if (node1_parent_code != null && node1_parent_code.equals(node2_code)) {
					mark = true;
					if (node2.get("children") == null) {
						node2.put("children", new ArrayList<Map<String, Object>>());
					}
					((List<Map<String, Object>>) node2.get("children")).add(node1);
					node2.put("leaf", false);
					if (!isChecked) {
						node2.put("expanded", true);
					}
					break;
				}
			}
			if (!mark) {
				nodeList.add(node1);
			}
		}
		return JsonUtil.toJson(nodeList);
	}

	public static List<Map<String, Object>> handleTree_userAdd(List<Map<String, Object>> menuList, boolean isChecked) {
		for (Map<String, Object> map : menuList) {
			map.put("id", map.get("user_id"));
			map.put("iconCls", map.get("url"));
			map.put("text", map.get("name"));
			map.put("leaf", true);
			if (isChecked) {
				map.put("checked", false);
			}
		}

		return menuList;
	}

	public static List<Map<String, Object>> handleTree_measure(List<Map<String, Object>> menuList, boolean isChecked) {
		for (Map<String, Object> map : menuList) {
			map.put("id", map.get("measure_code"));
			map.put("iconCls", map.get("url"));
			map.put("text", map.get("measure_name"));
			map.put("leaf", true);
			if (isChecked) {
				map.put("checked", false);
			}
		}

		return menuList;
	}

	public static String turnListToTree_measure(List<Map<String, Object>> menuList) {
		// 转换List为树形结构
		return turnListToTree_measure(menuList, false);
	}

	@SuppressWarnings("unchecked")
	public static String turnListToTree_measure(List<Map<String, Object>> menuList, boolean isChecked) {
		// 转换List为树形结构
		menuList = handleTree_bank(menuList, isChecked);

		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> node1 : menuList) {
			String node1_code = (String) node1.get("measure_code");
			String node1_parent_code = node1_code.substring(0, node1_code.length() - 3);

			boolean mark = false;
			for (Map<String, Object> node2 : menuList) {
				String node2_code = (String) node2.get("measure_code");

				if (node1_parent_code != null && node1_parent_code.equals(node2_code)) {
					mark = true;
					if (node2.get("children") == null) {
						node2.put("children", new ArrayList<Map<String, Object>>());
					}
					((List<Map<String, Object>>) node2.get("children")).add(node1);
					node2.put("leaf", false);
					if (!isChecked) {
						node2.put("expanded", true);
					}
					break;
				}
			}
			if (!mark) {
				nodeList.add(node1);
			}
		}
		return JsonUtil.toJson(nodeList);
	}

	// 预处理分类树节点
	public static List<Map<String, Object>> handleTree_category(List<Map<String, Object>> menuList) {
		return handleTree_category(menuList, false);
	}

	// 预处理分类树节点
	public static List<Map<String, Object>> handleTree_category(List<Map<String, Object>> menuList, boolean isChecked) {
		for (Map<String, Object> map : menuList) {
			map.put("id", map.get("category_id"));
			map.put("text", map.get("name"));
			map.put("leaf", true);
			if (isChecked) {
				map.put("checked", false);
			}
		}

		return menuList;
	}

	// 积分系统分类树
	/**
	 * 
	 * @param menuList
	 * @return
	 * @author Qinyp 2019-11-21
	 */
	public static String sysCategoryTreeNo(List<Map<String, Object>> menuList) {
		// 转换List为树形结构
		return sysCategoryTreeNo(menuList, false);
	}

	// 积分系统分类树
	/**
	 * @param menuList
	 * @param isChecked
	 * @return
	 * @author Qinyp 2019-11-21
	 */
	@SuppressWarnings("unchecked")
	public static String sysCategoryTreeNo(List<Map<String, Object>> menuList, boolean isChecked) {
		// 转换List为树形结构

		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> node1 : menuList) {

			String node1_code = (String) node1.get("id");
			String node1_parent_code = (String) node1.get("parent_id");
			boolean mark = false;
			for (Map<String, Object> node2 : menuList) {
				String node2_code = (String) node2.get("id");

				if (node1_parent_code != null && node1_parent_code.equals(node2_code)) {
					mark = true;
					if (node2.get("children") == null) {
						node2.put("children", new ArrayList<Map<String, Object>>());
					}
					((List<Map<String, Object>>) node2.get("children")).add(node1);
					// node2.put("leaf", false);
					if (!isChecked) {
						// node2.put("expanded", false);
					}
					break;
				}
			}
			if (!mark) {
				nodeList.add(node1);
			}
		}
		return JsonUtil.toJson(nodeList);
	}

}
