package org.qianrenxi.common.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseCrudService<R extends JpaRepository<T, ID>, T, ID extends Serializable> {
	@Autowired
	protected R repository;
	
	/**
	 * Saves a given entity. Use the returned instance for further operations as
	 * the save operation might have changed the entity instance completely.
	 * 
	 * @param entity
	 * @return the saved entity
	 */
	public <S extends T> S save(S entity) {
		return repository.save(entity);
	}

	/**
	 * Saves all given entities.
	 * 
	 * @param entities
	 * @return the saved entities
	 * @throws IllegalArgumentException
	 *             in case the given entity is {@literal null}.
	 */
	public <S extends T> Iterable<S> save(Iterable<S> entities) {
		return repository.save(entities);
	}

	/**
	 * Retrieves an entity by its id.
	 * 
	 * @param id
	 *            must not be {@literal null}.
	 * @return the entity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException
	 *             if {@code id} is {@literal null}
	 */
	public T findOne(ID id) {
		return repository.findOne(id);
	}
	
	/**
	 * Returns a reference to the entity with the given identifier.
	 * 
	 * @param id must not be {@literal null}.
	 * @return a reference to the entity with the given identifier.
	 * @see EntityManager#getReference(Class, Object)
	 */
	public T getOne(ID id){
		return findOne(id);
	}

	/**
	 * Returns whether an entity with the given id exists.
	 * 
	 * @param id
	 *            must not be {@literal null}.
	 * @return true if an entity with the given id exists, {@literal false}
	 *         otherwise
	 * @throws IllegalArgumentException
	 *             if {@code id} is {@literal null}
	 */
	public boolean exists(ID id) {
		return repository.exists(id);
	}

	/**
	 * Returns all instances of the type.
	 * 
	 * @return all entities
	 */
	public Iterable<T> findAll() {
		return repository.findAll();
	}

	/**
	 * Returns all instances of the type with the given IDs.
	 * 
	 * @param ids
	 * @return
	 */
	public Iterable<T> findAll(Iterable<ID> ids) {
		return repository.findAll(ids);
	}

	/**
	 * Returns the number of entities available.
	 * 
	 * @return the number of entities
	 */
	public long count() {
		return repository.count();
	}

	/**
	 * Deletes the entity with the given id.
	 * 
	 * @param id
	 *            must not be {@literal null}.
	 * @throws IllegalArgumentException
	 *             in case the given {@code id} is {@literal null}
	 */
	public void delete(ID id) {
		repository.delete(id);
	}
	
	public void delete(List<ID> ids){
		for(ID id: ids){
			delete(id);
		}
	}
	
	public void delete(ID[] ids){
		for(ID id: ids){
			delete(id);
		}
	}

	/**
	 * Deletes a given entity.
	 * 
	 * @param entity
	 * @throws IllegalArgumentException
	 *             in case the given entity is {@literal null}.
	 */
	public void delete(T entity) {
		repository.delete(entity);
	}

	/**
	 * Deletes the given entities.
	 * 
	 * @param entities
	 * @throws IllegalArgumentException
	 *             in case the given {@link Iterable} is {@literal null}.
	 */
	public void delete(Iterable<? extends T> entities) {
		repository.delete(entities);
	}

	/**
	 * Deletes all entities managed by the repository.
	 */
	public void deleteAll() {
		repository.deleteAll();
	}
	
	public <S extends T> Iterable<S> findAll(S entity){
		return repository.findAll(Example.of(entity));
	}
	
	public <S extends T> Page<S> findAll(S entity, Pageable pageable){
		return repository.findAll(Example.of(entity), pageable);
	}
}
