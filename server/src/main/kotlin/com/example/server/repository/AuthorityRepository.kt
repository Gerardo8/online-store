package com.example.server.repository

import com.example.server.domain.Authority
import org.springframework.data.repository.CrudRepository

interface AuthorityRepository : CrudRepository<Authority, Short>
