package com.Digital.Digital.Entity.Availibility;


import com.Digital.Digital.Entity.Availibility.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class City {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany( mappedBy = "city", fetch = FetchType.LAZY)
    private List<Address> addressList;
}
