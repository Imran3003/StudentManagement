package com.ib.stm.repos;

import com.ib.stm.models.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * UserInfoRepo.java
 *
 * @author Mohamed Subaideen Imran A (mohamedsubaideenimran@nmsworks.co.in)
 * @module com.ib.stm.repos
 * @created Dec 19, 2023
 */

public interface UserInfoRepo extends CrudRepository<UserInfo, Integer> {
    boolean existsByRegNoAndDob(String regNo, long dob);
    boolean existsByRegNoAndDobAndPassword(String regNo, long dob, String password);
}
