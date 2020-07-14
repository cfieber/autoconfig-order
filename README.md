# autoconfiguration ordering test

My expectation is that if AutoConfiguration `@Configuration` classes express relationships between each
other via `@AutoConfigureBefore` or `@AutoConfigureAfter` that `@Bean`s in one `@Configuration` will be created
before `@Bean`s in the other.

It appears that adding a dependency on a `@Bean` that is created in an AutoConfiguration `@Configuration` class causes
the AutoConfiguration ordering to fail.

This sample project demonstrates a case where the autoconfiguration order is not honored.

This is modelled of a real world scenario, simplified as much as possible to reproduce the issue:

# project modules

## badlib
`badlib` is a legacy library that does non DI friendly things

`BadConfig` stores its configuration as static state.

`BadClient` reads `BadConfig`'s static state. There is not a constructor time dependency there, but there is an ordering
dependency such that BadConfig needs to be configured properly before `BadClient` is created.

## autoconfigs

`BadConfigAutoConfiguration` sets up `BadConfig` correctly.

`BadClientAutoConfiguration` creates a `BadClient` but requires that the `BadConfig` is in a good state.

`BadConfiguAutoConfiguration` is annotated `@AutoConfigureBefore(BadClientAutoConfiguration.class)`

## bootapp

A spring-boot main and spring-boot tests demonstrating successful startup and triggering failure.

### triggering failure

If there is a component that adds a dependency on `BadClient`, `BadClient` gets created before the
`BadConfigAutoConfiguration` happens.

see `BreakyTest` that introduces a `BreakyConfig` referencing `BadClient`


