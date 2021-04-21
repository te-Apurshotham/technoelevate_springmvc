package com.te.springmvc2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.springmvc2.bean.EmployeeBean;
import com.te.springmvc2.exceptions.EmployeeExp;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public EmployeeBean authenticate(int id, String password) {
		EntityManager manager = factory.createEntityManager();

		try {
			EmployeeBean bean = manager.find(EmployeeBean.class, id);
			if (bean != null) {
				if (bean.getPassword().equals(password)) {
					System.out.println("login successfull");
					return bean;
				} else {
					System.out.println("invalid credentials");
					throw new EmployeeExp("user not found");
				}
			} else {
				throw new EmployeeExp("user not found");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		throw new EmployeeExp("user not found");

	} // end of authenticate

	@Override
	public EmployeeBean getEmployee(int id) {
		EntityManager manager = factory.createEntityManager();
		try {
			EmployeeBean bean = manager.find(EmployeeBean.class, id);
			if (bean != null) {
				return bean;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (manager != null) {
				manager.close();
			}
		}
		return null;

	}// end of getEmployee

	@Override
	public boolean deleteEmp(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			EmployeeBean bean2 = manager.find(EmployeeBean.class, id);
			if (bean2 != null) {
				manager.remove(bean2);
				transaction.commit();
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (manager != null) {
				manager.close();
			}
		}

		return false;
	}// end of deleteEmp

	@Override
	public List<EmployeeBean> getAllEmployees() {
		EntityManager manager = factory.createEntityManager();

		try {
			String select = "from EmployeeBean";

			Query query = manager.createQuery(select);

			List<EmployeeBean> list = query.getResultList();

			if (list != null) {
				return list;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (manager != null) {
				manager.close();
			}
		}
		return null;

	}// end of getAllEmployess

	@Override
	public boolean updateEmp(EmployeeBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isUpdated = false;
		try {
			transaction.begin();
			EmployeeBean info = manager.find(EmployeeBean.class, bean.getId());
			if (bean.getName() != null && bean.getName() != "") {
				info.setName(bean.getName());
			}
			if (bean.getDob() != null) {
				info.setDob(bean.getDob());
			}
			if (bean.getPassword() != null && bean.getPassword() != "") {
				info.setPassword(bean.getPassword());
			}
			transaction.commit();
			isUpdated = true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			isUpdated = false;
		}

		return isUpdated;

	}// end of updateEmp

	@Override
	public boolean getAddEmpForm(EmployeeBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(bean);

			if (bean != null) {
				transaction.commit();
				isAdded = true;

			}
		} catch (Exception e) {
			isAdded = false;
			e.printStackTrace();
		}

		return isAdded;

	}

} // end of class
