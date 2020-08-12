package com.cts.sr.moviecruiser.user.repository;

import com.cts.sr.moviecruiser.user.model.User;
import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;

import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCosmosRepository<User, String> {

	public Mono<User> findByUserIdAndPassword(String userId, String password);

	public User findByUserId(String userId);
}
