/**
 * @author Sindhu
 * Date: 9-June-2019
 */
package com.igreen.ex.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.igreen.ex.model.AccountDetails;
/**
 * 
 * Account table Repository file
 *
 */
@RepositoryRestResource
public interface AccountDetailsRepository extends CrudRepository<AccountDetails, Long>
{
	List<AccountDetails> findByUserId(@Param("userId") Long userId);
}
