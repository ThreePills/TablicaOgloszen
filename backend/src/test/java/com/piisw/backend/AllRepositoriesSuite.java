package com.piisw.backend;

import com.piisw.backend.repository.ContactRepositoryTests;
import com.piisw.backend.repository.LocalizationRepositoryTests;
import com.piisw.backend.repository.OfferRepositoryTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  ContactRepositoryTests.class,
  LocalizationRepositoryTests.class,
  OfferRepositoryTests.class
})
public class AllRepositoriesSuite {}
