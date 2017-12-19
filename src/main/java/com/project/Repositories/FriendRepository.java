package com.project.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.project.Entity.FriendRequest;


public interface FriendRepository extends CrudRepository<FriendRequest, Integer> {

}
