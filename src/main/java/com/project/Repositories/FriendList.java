package com.project.Repositories;
import org.springframework.data.repository.CrudRepository;
import com.project.Entity.Friend;
public interface FriendList extends CrudRepository<Friend, Integer> {

}
