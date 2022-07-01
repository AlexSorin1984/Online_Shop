package com.sorin.onlineshop.model;

import lombok.*;

import javax.persistence.*;

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
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    //@ManyToOne(fetch = FetchType.EAGER, optional = false)
    //@JoinColumn(name = "category_id", nullable = false)
//    @ManyToOne
//    @JoinColumn(name="category_id")
//    private Category category;
    private String product;
    private Long price;

    public Product(String product, Long price) {
        this.product = product;
        this.price = price;
    }
}
