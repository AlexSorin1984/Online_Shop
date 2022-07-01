package com.sorin.onlineshop.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name="category")
    private String category;
    //@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    //@OneToMany(targetEntity = Product.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "category_id")
    private List<Product> products = new ArrayList<>();

    public Category(String category, List<Product> products) {
        this.category = category;
        this.products = products;
    }
}
