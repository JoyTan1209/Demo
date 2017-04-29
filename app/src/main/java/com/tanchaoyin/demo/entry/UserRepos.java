package com.tanchaoyin.demo.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tanchaoyin on 2017/4/28.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRepos {

    @JsonProperty("language")
    public String language;

    @JsonProperty("owner")
    public Owner owner;

//    @JsonProperty("id")
//    public String id;
//
//    @JsonProperty("name")
//    public String name;
//
//    @JsonProperty("full_name")
//    public String full_name;
//
//
//    @JsonProperty("private")
//    public boolean isPrivate;
//
//    @JsonProperty("html_url")
//    public String html_url;
//
//    @JsonProperty("description")
//    public String description;
//
//    @JsonProperty("fork")
//    public boolean fork;
//
//    @JsonProperty("url")
//    public String url;
//
//    @JsonProperty("forks_url")
//    public String forks_url;
//
//    @JsonProperty("keys_url")
//    public String keys_url;
//
//    @JsonProperty("collaborators_url")
//    public String collaborators_url;
//
//    @JsonProperty("teams_url")
//    public String teams_url;
//
//    @JsonProperty("hooks_url")
//    public String hooks_url;
//
//    @JsonProperty("issue_events_url")
//    public String issue_events_url;
//
//    @JsonProperty("events_url")
//    public String events_url;
//
//    @JsonProperty("assignees_url")
//    public String assignees_url;
//
//    @JsonProperty("branches_url")
//    public String branches_url;
//
//    @JsonProperty("tags_url")
//    public String tags_url;
//
//    @JsonProperty("blobs_url")
//    public String blobs_url;
//
//    @JsonProperty("git_tags_url")
//    public String git_tags_url;
//
//    @JsonProperty("git_refs_url")
//    public String git_refs_url;
//
//    @JsonProperty("trees_url")
//    public String trees_url;
//
//    @JsonProperty("statuses_url")
//    public String statuses_url;
//
//    @JsonProperty("languages_url")
//    public String languages_url;
//
//    @JsonProperty("stargazers_url")
//    public String stargazers_url;
//
//    @JsonProperty("contributors_url")
//    public String contributors_url;
//
//    @JsonProperty("subscribers_url")
//    public String subscribers_url;
//
//    @JsonProperty("subscription_url")
//    public String subscription_url;
//
//    @JsonProperty("commits_url")
//    public String commits_url;
//
//    @JsonProperty("git_commits_url")
//    public String git_commits_url;
//
//    @JsonProperty("comments_url")
//    public String comments_url;
//
//    @JsonProperty("issue_comment_url")
//    public String issue_comment_url;
//
//    @JsonProperty("contents_url")
//    public String contents_url;
//
//    @JsonProperty("compare_url")
//    public String compare_url;
//
//    @JsonProperty("merges_url")
//    public String merges_url;
//
//    @JsonProperty("archive_url")
//    public String archive_url;
//
//    @JsonProperty("downloads_url")
//    public String downloads_url;
//
//    @JsonProperty("issues_url")
//    public String issues_url;
//
//    @JsonProperty("pulls_url")
//    public String pulls_url;
//
//    @JsonProperty("milestones_url")
//    public String milestones_url;
//
//    @JsonProperty("notifications_url")
//    public String notifications_url;
//
//    @JsonProperty("labels_url")
//    public String labels_url;
//
//    @JsonProperty("releases_url")
//    public String releases_url;
//
//    @JsonProperty("deployments_url")
//    public String deployments_url;
//
//    @JsonProperty("created_at")
//    public String created_at;
//
//    @JsonProperty("updated_at")
//    public String updated_at;
//
//    @JsonProperty("pushed_at")
//    public String pushed_at;
//
//    @JsonProperty("git_url")
//    public String git_url;
//
//    @JsonProperty("ssh_url")
//    public String ssh_url;
//
//    @JsonProperty("clone_url")
//    public String clone_url;
//
//    @JsonProperty("svn_url")
//    public String svn_url;
//
//    @JsonProperty("homepage")
//    public String homepage;
//
//    @JsonProperty("size")
//    public String size;
//
//    @JsonProperty("stargazers_count")
//    public int stargazers_count;

//    @JsonProperty("has_issues")
//    public String has_issues;
//
//    @JsonProperty("has_projects")
//    public String has_projects;
//
//    @JsonProperty("has_downloads")
//    public String has_downloads;
//
//    @JsonProperty("has_wiki")
//    public String has_wiki;
//
//    @JsonProperty("has_pages")
//    public String has_pages;
//
//    @JsonProperty("forks_count")
//    public String forks_count;
//
//    @JsonProperty("mirror_url")
//    public String mirror_url;
//
//    @JsonProperty("open_issues_count")
//    public String open_issues_count;
//
//    @JsonProperty("forks")
//    public String forks;
//
//    @JsonProperty("open_issues")
//    public String open_issues;
//
//    @JsonProperty("watchers")
//    public String watchers;
//
//    @JsonProperty("default_branch")
//    public String default_branch;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Owner {

//        @JsonProperty("login")
//        public String login;

        @JsonProperty("id")
        public String id;

//        @JsonProperty("avatar_url")
//        public String avatar_url;
//
//        @JsonProperty("gravatar_id")
//        public String gravatar_id;
//
//        @JsonProperty("url")
//        public String url;
//
//        @JsonProperty("html_url")
//        public String html_url;
//
//        @JsonProperty("followers_url")
//        public String followers_url;
//
//        @JsonProperty("following_url")
//        public String following_url;
//
//        @JsonProperty("gists_url")
//        public String gists_url;
//
//        @JsonProperty("starred_url")
//        public String starred_url;
//
//        @JsonProperty("subscriptions_url")
//        public String subscriptions_url;
//
//        @JsonProperty("organizations_url")
//        public String organizations_url;
//
//        @JsonProperty("repos_url")
//        public String repos_url;
//
//        @JsonProperty("events_url")
//        public String events_url;
//
//        @JsonProperty("received_events_url")
//        public String received_events_url;
//
//        @JsonProperty("type")
//        public String type;
//
//        @JsonProperty("site_admin")
//        public String site_admin;
    }

    /**
     * "owner": {
     "login": "joy0304",
     "id": 7369112,
     "avatar_url": "https://avatars0.githubusercontent.com/u/7369112?v=3",
     "gravatar_id": "",
     "url": "https://api.github.com/users/joy0304",
     "html_url": "https://github.com/joy0304",
     "followers_url": "https://api.github.com/users/joy0304/followers",
     "following_url": "https://api.github.com/users/joy0304/following{/other_user}",
     "gists_url": "https://api.github.com/users/joy0304/gists{/gist_id}",
     "starred_url": "https://api.github.com/users/joy0304/starred{/owner}{/repo}",
     "subscriptions_url": "https://api.github.com/users/joy0304/subscriptions",
     "organizations_url": "https://api.github.com/users/joy0304/orgs",
     "repos_url": "https://api.github.com/users/joy0304/repos",
     "events_url": "https://api.github.com/users/joy0304/events{/privacy}",
     "received_events_url": "https://api.github.com/users/joy0304/received_events",
     "type": "User",
     "site_admin": false
     },
     */

    /**
     * "id": 61690286,
     "name": "A-GUIDE-TO-iOS-ANIMATION",
     "full_name": "joy0304/A-GUIDE-TO-iOS-ANIMATION",
     "private": false,
     "html_url": "https://github.com/joy0304/A-GUIDE-TO-iOS-ANIMATION",
     "description": "The source code of my new eBook —— A GUIDE TO IOS ANIMATION. Just click the next link to buy it",
     "fork": true,
     "url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION",
     "forks_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/forks",
     "keys_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/keys{/key_id}",
     "collaborators_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/collaborators{/collaborator}",
     "teams_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/teams",
     "hooks_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/hooks",
     "issue_events_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/issues/events{/number}",
     "events_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/events",
     "assignees_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/assignees{/user}",
     "branches_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/branches{/branch}",
     "tags_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/tags",
     "blobs_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/git/blobs{/sha}",
     "git_tags_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/git/tags{/sha}",
     "git_refs_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/git/refs{/sha}",
     "trees_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/git/trees{/sha}",
     "statuses_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/statuses/{sha}",
     "languages_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/languages",
     "stargazers_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/stargazers",
     "contributors_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/contributors",
     "subscribers_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/subscribers",
     "subscription_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/subscription",
     "commits_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/commits{/sha}",
     "git_commits_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/git/commits{/sha}",
     "comments_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/comments{/number}",
     "issue_comment_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/issues/comments{/number}",
     "contents_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/contents/{+path}",
     "compare_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/compare/{base}...{head}",
     "merges_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/merges",
     "archive_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/{archive_format}{/ref}",
     "downloads_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/downloads",
     "issues_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/issues{/number}",
     "pulls_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/pulls{/number}",
     "milestones_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/milestones{/number}",
     "notifications_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/notifications{?since,all,participating}",
     "labels_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/labels{/name}",
     "releases_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/releases{/id}",
     "deployments_url": "https://api.github.com/repos/joy0304/A-GUIDE-TO-iOS-ANIMATION/deployments",
     "created_at": "2016-06-22T05:02:32Z",
     "updated_at": "2016-06-22T05:02:37Z",
     "pushed_at": "2016-04-26T09:39:11Z",
     "git_url": "git://github.com/joy0304/A-GUIDE-TO-iOS-ANIMATION.git",
     "ssh_url": "git@github.com:joy0304/A-GUIDE-TO-iOS-ANIMATION.git",
     "clone_url": "https://github.com/joy0304/A-GUIDE-TO-iOS-ANIMATION.git",
     "svn_url": "https://github.com/joy0304/A-GUIDE-TO-iOS-ANIMATION",
     "homepage": "http://book.kittenyang.com/",
     "size": 24614,
     "stargazers_count": 0,
     "watchers_count": 0,
     "language": "Objective-C",
     "has_issues": false,
     "has_projects": true,
     "has_downloads": true,
     "has_wiki": true,
     "has_pages": false,
     "forks_count": 0,
     "mirror_url": null,
     "open_issues_count": 0,
     "forks": 0,
     "open_issues": 0,
     "watchers": 0,
     "default_branch": "master"
     */
}
