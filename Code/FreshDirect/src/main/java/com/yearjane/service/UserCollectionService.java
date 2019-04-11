package com.yearjane.service;

import com.yearjane.dto.UserCollectionExecution;
import com.yearjane.entity.UserCollections;

public interface UserCollectionService {
  public UserCollectionExecution addCollection(UserCollections userCollections) ;
  
  public UserCollectionExecution getUserCollections(UserCollections userCollections);
  
  public UserCollectionExecution deleteUserCollections(UserCollections userCollections);
}
