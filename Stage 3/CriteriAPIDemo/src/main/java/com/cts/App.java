package com.cts;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager manager = emf.createEntityManager();
		// fetch all records from table
		System.out.println("================== Display all Products==========");
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> prd = cq.from(Product.class);
		cq.select(prd);
		TypedQuery<Product> q = manager.createQuery(cq);
		List<Product> prodlist = q.getResultList();
		show(prodlist);

		System.out.println("================= Find By Name =========");
		cb = manager.getCriteriaBuilder();
		cq = cb.createQuery(Product.class);
		prd = cq.from(Product.class);
		cq.select(prd);

		cq.where(cb.equal(prd.<String>get("name"), "Lenovo"));
		q = manager.createQuery(cq);
		prodlist = q.getResultList();
		show(prodlist);

		System.out.println("================= Find By RamSize =========");
		cb = manager.getCriteriaBuilder();
		cq = cb.createQuery(Product.class);
		prd = cq.from(Product.class);
		cq.select(prd);
		cq.where(cb.equal(prd.<String>get("ramSize"), "8gb"));
		q = manager.createQuery(cq);
		prodlist = q.getResultList();
		show(prodlist);

		System.out.println("================= Find By HardDiskSize =========");
		cb = manager.getCriteriaBuilder();
		cq = cb.createQuery(Product.class);
		prd = cq.from(Product.class);
		cq.select(prd);
		cq.where(cb.equal(prd.<String>get("hardDiskSize"), "1tb"));
		q = manager.createQuery(cq);
		prodlist = q.getResultList();
		show(prodlist);

		System.out.println("================= Find By Weight =========");
		cb = manager.getCriteriaBuilder();
		cq = cb.createQuery(Product.class);
		prd = cq.from(Product.class);
		cq.select(prd);
		cq.where(cb.equal(prd.<Double>get("weight"), 1.5));
		q = manager.createQuery(cq);
		prodlist = q.getResultList();
		show(prodlist);

		System.out.println("================= Find By CustomerReview =========");
		cb = manager.getCriteriaBuilder();
		cq = cb.createQuery(Product.class);
		prd = cq.from(Product.class);
		cq.select(prd);
		cq.where(cb.equal(prd.<String>get("customerReview"), "good"));
		q = manager.createQuery(cq);
		prodlist = q.getResultList();
		show(prodlist);

		System.out.println("================= Find By CPUSpeed =========");
		cb = manager.getCriteriaBuilder();
		cq = cb.createQuery(Product.class);
		prd = cq.from(Product.class);
		cq.select(prd);
		cq.where(cb.equal(prd.<String>get("cpuSpeed"), "2Mhz"));
		q = manager.createQuery(cq);
		prodlist = q.getResultList();
		show(prodlist);

		System.out.println("================= Find By OperaringSystem =========");
		cb = manager.getCriteriaBuilder();
		cq = cb.createQuery(Product.class);
		prd = cq.from(Product.class);
		cq.select(prd);
		cq.where(cb.equal(prd.<String>get("operatingSystem"), "Win"));
		q = manager.createQuery(cq);
		prodlist = q.getResultList();
		show(prodlist);

		System.out.println("================= Find By CPU =========");
		cb = manager.getCriteriaBuilder();
		cq = cb.createQuery(Product.class);
		prd = cq.from(Product.class);
		cq.select(prd);
		cq.where(cb.equal(prd.<String>get("cpu"), "intel"));
		q = manager.createQuery(cq);
		prodlist = q.getResultList();
		show(prodlist);

	}

	static void show(List<Product> prodlist) {
		{
			System.out.println(prodlist);
		}
	}
}