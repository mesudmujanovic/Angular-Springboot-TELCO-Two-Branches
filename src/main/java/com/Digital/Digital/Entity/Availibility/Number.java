package com.Digital.Digital.Entity.Availibility;


import com.Digital.Digital.Entity.Availibility.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Number {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private Integer num;

    @ManyToOne
    @JoinColumn( name="address_id" )
    private Address address;
}
