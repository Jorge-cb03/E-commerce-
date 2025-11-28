package com.ecommerce.app;

import com.ecommerce.domain.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(">>> INICIANDO JPA SIN SPRING BOOT...");

        // 1. Iniciar la fábrica de EntityManager (carga persistence.xml)
        // El nombre "ecommercePU" debe coincidir con el del xml.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");
        EntityManager em = emf.createEntityManager();

        try {
            // 2. Iniciar transacción manual (obligatorio en escritura)
            em.getTransaction().begin();

            // 3. Consulta (JPQL)
            System.out.println(">>> Consultando Clientes...");
            List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class)
                                       .getResultList();

            if (clientes.isEmpty()) {
                System.out.println(">>> Base de datos vacía o conexión fallida en datos.");
            } else {
                for (Cliente c : clientes) {
                    System.out.println("Cliente encontrado: " + c.getNombreCompleto() + " | Email: " + c.getCorreoElectronico());
                }
            }

            // 4. Commit (si hubiéramos hecho cambios)
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            // 5. Cerrar recursos
            em.close();
            emf.close();
            System.out.println(">>> CONEXIÓN CERRADA.");
        }
    }
}