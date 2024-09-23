job('example-freestyle-job') {
    description 'This is an example of a freestyle job created using a DSL script'
   
    scm {
        git('https://github.com/your-organization/your-repo.git', 'main')
    }

    triggers {
        scm('H/5 * * * *')  // Poll SCM every 5 minutes
    }

    steps {
        shell('echo Hello, Freestyle World!')
    }

    publishers {
        archiveArtifacts('**/*')  // Archive all artifacts
    }

    wrappers {
        preBuildCleanup()  // Clean workspace before build starts
    }
}