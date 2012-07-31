package org.artifactory.client

import org.artifactory.client.model.impl.ItemImpl

/**
 *GET /api/storage/{repo}/{item-path}?lastModified
 *
 * @author jbaruch
 * @since 25/07/12
 */
class ItemLastModified {

    private Artifactory artifactory
    private String repoKey
    private String itemPath

    ItemLastModified(Artifactory artifactory) {
        this.artifactory = artifactory
    }

    ItemLastModified repoKey(String repoKey) {
        this.repoKey = repoKey
        this
    }

    ItemLastModified itemPath(String filePath) {
        this.itemPath = filePath
        this
    }

    void get() {
        assert artifactory
        assert repoKey
        assert itemPath
        artifactory.getJson("/api/storage/$repoKey/$itemPath", ItemImpl, [lastModified:''])
    }
}
