package com.te.springmvc2.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springmvc2.bean.EmployeeBean;
import com.te.springmvc2.service.EmployeeService;

@Controller
public class EmployeeController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private EmployeeService service;

	@GetMapping("/empLogin")
	public String getLogin() {
		return "loginPage";

	}// end of getLogin

	@PostMapping("/empLogin")
	public String authenticate(int id, String password, HttpServletRequest request, ModelMap map) {
		EmployeeBean employeeBean = service.authenticate(id, password);

		if (employeeBean != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("emp", employeeBean);
			return "homePage";

		} else {
			map.addAttribute("errMsg", "inavlid crendtials");
			return "loginPage";
		}

	}// end of authenticate

	@GetMapping("/search1")
	public String getSearchForm(ModelMap map, HttpSession session) {
		if (session.getAttribute("emp") != null) {
			return "search";

		} else {
			map.addAttribute("errMsg", "inavlid crendtials");
			return "loginPage";
		}

	}// end of getSearchForm

	@GetMapping("/searchForm")
	public String searchEmp(int id, ModelMap map, @SessionAttribute(name = "emp", required = false) EmployeeBean bean) {
		if (bean != null) {
			EmployeeBean employeeBean2 = service.getEmployee(id);
			if (employeeBean2 != null) {
				map.addAttribute("data", employeeBean2);

			} else {
				map.addAttribute("msg", "data not found for id :" + id);

			}
			return "search";

		} else {
			map.addAttribute("errMsg", "please login first");
			return "loginPage";
		}

	}// end of searchForm

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "logout succesful");
		return "loginPage";

	}// end of logout

	@GetMapping("/getdeleteform")
	public String getDeleteForm(ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			return "delete";
		} else {
			map.addAttribute("errMsg", "please login first");
			return "loginPage";

		}

	}// end of getDeleteForm

	@GetMapping("/delete")
	public String deleteEmployee(int id, @SessionAttribute(name = "emp", required = false) EmployeeBean bean,
			ModelMap map) {
		if (bean != null) {
			boolean deleted = service.deleteEmp(id);
			if (deleted == true) {
				map.addAttribute("msg", "deleted successfully");
				return "delete";
			} else {
				map.addAttribute("errmsg", "user not found");
				return "delete";
			}

		}

		return "loginPage";

	}// end of deleteEmployee

	@GetMapping("/getAll")
	public String viewAllEmployee(ModelMap map, @SessionAttribute(name = "emp", required = false) EmployeeBean bean) {
		if (bean != null) {
			List<EmployeeBean> employeeBeans = service.getAllEmployees();
			if (employeeBeans != null) {
				map.addAttribute("empdata", employeeBeans);
				return "getAll";
				
			}
		} else {
			map.addAttribute("msg", "no employees found");
			return "loginPage";
			
			
		}
		return "loginPage";
		
		

	}// end of viewAllEmployee

	@GetMapping("/addForm")
	public String getAddEmployee(@SessionAttribute(name = "emp", required = false) EmployeeBean bean, ModelMap map) {
		if (bean != null) {
			return "register";
		} else {
			map.addAttribute("msg", "Please login first");
			return "loginPage";
		}
	}

	@PostMapping("/add")
	public String addEmployee(EmployeeBean empdata, @SessionAttribute(name = "emp", required = false) EmployeeBean bean,
			ModelMap map) {
		if (bean != null) {
			if (service.getAddEmpForm(empdata)) {
				map.addAttribute("msg", "added successfully");
				return "register";
			} else {
				map.addAttribute("errMsg", "something went wrong");
				return "register";
			}
		} else {
			map.addAttribute("msg", "please login first");
			return "loginPage";
		}
	}

	@GetMapping("/updateForm")
	public String updateEmployee(@SessionAttribute(name = "emp", required = false) EmployeeBean bean, ModelMap map) {
		if (bean != null) {
			map.addAttribute("id", bean.getId());
			return "update";
		} else {
			map.addAttribute("errorMsg", "please login first");
			return "loginPage";
		}
	}

	@PostMapping("/update")
	public String updateEmployee(@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean,
			ModelMap map, EmployeeBean empData) {
		if (employeeBean != null) {

			if (service.updateEmp(empData)) {
				map.addAttribute("id", employeeBean.getId());
				map.addAttribute("msg", "updated successfully");
			} else {
				map.addAttribute("msg", "something went wrong");

			}
			return "update";

		} else {
			map.addAttribute("errorMsg", "please login first");
			return "loginPage";

		}

	}

}// end of controller
