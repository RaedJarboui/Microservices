package com.service.personnels.Repositorie;



import org.springframework.data.jpa.repository.JpaRepository;

import com.service.personnels.entities.Personnel;




public interface PersonnelRepository  extends JpaRepository<Personnel,Integer> {

}
