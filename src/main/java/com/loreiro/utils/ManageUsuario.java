package com.loreiro.utils;

import java.util.List; 

import java.util.Iterator; 

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.loreiro.model.Usuario;

public class ManageUsuario {
   
	private static SessionFactory factoryUsuario; 
   
   public static void main(String[] args) {
      try{
    	  factoryUsuario = new Configuration().configure().buildSessionFactory();
      }catch (Throwable ex) { 
    	  factoryUsuario = new Configuration().configure().buildSessionFactory();
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      
      ManageUsuario ME = new ManageUsuario();

      /* Add few Usuario records in database */
      Integer empID1 = ME.addUsuario("Zara", "Ali", 1000);
      Integer empID2 = ME.addUsuario("Daisy", "Das", 5000);
      Integer empID3 = ME.addUsuario("John", "Paul", 10000);

      /* List down all the Usuarios */
      ME.listUsuarios();

      /* Update Usuario's records */
      ME.updateUsuario(empID1, 5000);

      /* Delete an Usuario from the database */
      ME.deleteUsuario(empID2);

      /* List down new list of the Usuarios */
      ME.listUsuarios();
   }
   /* Method to CREATE an Usuario in the database */
   public Integer addUsuario(String fname, String lname, int salary){
      Session session = factoryUsuario.openSession();
      Transaction tx = null;
      Integer UsuarioID = null;
      try{
         tx = session.beginTransaction();
         Usuario Usuario = new Usuario(fname, lname, salary);
         UsuarioID = (Integer) session.save(Usuario); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return UsuarioID;
   }
   /* Method to  READ all the Usuarios */
   public void listUsuarios( ){
      Session session = factoryUsuario.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List Usuarios = session.createQuery("FROM Usuario").list(); 
         for (Iterator iterator = 
                           Usuarios.iterator(); iterator.hasNext();){
            Usuario Usuario = (Usuario) iterator.next(); 
            System.out.print("First Name: " + Usuario.getFirstName()); 
            System.out.print("  Last Name: " + Usuario.getLastName()); 
            System.out.println("  Salary: " + Usuario.getSalary()); 
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   /* Method to UPDATE salary for an Usuario */
   public void updateUsuario(Integer UsuarioID, int salary ){
      Session session = factoryUsuario.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Usuario Usuario = 
                    (Usuario)session.get(Usuario.class, UsuarioID); 
         Usuario.setSalary( salary );
		 session.update(Usuario); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   /* Method to DELETE an Usuario from the records */
   public void deleteUsuario(Integer UsuarioID){
      Session session = factoryUsuario.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Usuario Usuario = 
                   (Usuario)session.get(Usuario.class, UsuarioID); 
         session.delete(Usuario); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
}