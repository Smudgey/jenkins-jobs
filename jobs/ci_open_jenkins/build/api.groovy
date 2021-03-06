package ci_open_jenkins.build
import javaposse.jobdsl.dsl.DslFactory
import uk.gov.hmrc.jenkinsjobbuilders.domain.builder.BuildMonitorViewBuilder
import uk.gov.hmrc.jenkinsjobs.domain.builder.SbtFrontendJobBuilder
import uk.gov.hmrc.jenkinsjobs.domain.builder.SbtLibraryJobBuilder

new SbtFrontendJobBuilder('api-revocation-frontend').
        withTests("test acceptance:test").
        withXvfb().
        build(this as DslFactory)

new SbtLibraryJobBuilder('play-json-union-formatter').
        build(this as DslFactory)

new SbtLibraryJobBuilder('totp-generator').
        build(this as DslFactory)

new SbtFrontendJobBuilder('api-gateway').
        withTests("test it:test").
        withXvfb().
        build(this as DslFactory)

new BuildMonitorViewBuilder('API-MONITOR')
        .withJobs('api-revocation-frontend',
        'play-json-union-formatter',
        'totp-generator',
        'api-gateway'
).build(this)
