package com.etiya.ecommercedemo3.entities.concretes;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "invoice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Invoice {
         @Column(name = "id")
         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int Id;
        @Column(name = "invoice_number")
        private int invoiceNumber;

    @OneToOne(targetEntity=Order.class,cascade=CascadeType.ALL)
        private Order order;

}
