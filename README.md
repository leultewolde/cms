# Content Management System

## Problem Statement & Description
The project aims to solve the problem of inefficient content creation, organization, and publishing. Organizations and individuals often struggle with this due to the lack of a centralized platform. This can lead to scattered content, inconsistent formatting, and difficulties with collaboration and version control. As a result, there can be delays, miscommunication, and poor content quality. To fix these issues, this project proposes building a content management system (CMS).

This CMS will provide users with a single platform to efficiently upload, organize, and publish digital content, which can be a picture, text, or video. It will improve the content creation process, teamwork, and version control. This will ultimately lead to higher-quality content and a more efficient workflow. The system will have three types of users: administrators, reviewers, and contributors. Administrators assign or remove users from their roles, assign tasks to contributors, and publish the final version to different content-hosting sites (for example, YouTube and TikTok for videos, Instagram and Twitter for photos, and Twitter for text-only content). Contributors can upload, organize, create text-based content, edit text-based content, and send their final version of the content to reviewers. Reviewers review content, make changes to text-based content, and send it to admins to get published. If a task needs to be redone, they can send it back to contributors with comments on what to fix. Editors must review all content before it is published by administrators. The system will track all published and draft content, as well as all changes made to the content. All users will have the ability to search for and filter all content based on different criteria.

### Functional Requirements for Content Management System (CMS)

- **User Roles and Permissions**
  - **Administrators**
    - Assign or remove users from their roles (administrator, reviewer, contributor).
    - Assign tasks to contributors.
    - Publish final versions of content to various content-hosting sites (YouTube, TikTok for videos, Instagram, Twitter for photos, Twitter for text-only content).
  - **Contributors**
    - Upload digital content (pictures, text, videos).
    - Organize and manage uploaded content.
    - Create and edit text-based content.
    - Send finalized content to reviewers for approval.
  - **Reviewers**
    - Review content submitted by contributors.
    - Make changes to text-based content.
    - Send content back to contributors with comments for further changes if necessary.
    - Approve content and send it to administrators for publication.

- **Content Creation and Management**
  - Provide a centralized platform for uploading, organizing, and managing digital content.
  - Allow text, image, and video content types.
  - Enable version control for all content, tracking changes and updates.
  - Facilitate collaboration between contributors and reviewers.
  - Ensure consistency in formatting across all content types.

- **Content Review and Approval Workflow**
  - Enable reviewers to provide feedback and comments on content.
  - Allow contributors to respond to feedback and make necessary revisions.
  - Implement a workflow for reviewers to approve or send content back to contributors.
  - Require all content to be reviewed and approved before publication.

- **Publishing and Distribution**
  - Support publishing of content to multiple platforms (YouTube, TikTok, Instagram, Twitter).
  - Allow administrators to select and configure target platforms for publishing.
  - Provide tools for scheduling content publication.

- **Content Tracking and History**
  - Track all draft and published content.
  - Maintain a history of all changes made to content, including who made the changes and when.
  - Allow users to view and revert to previous versions of content if necessary.

- **Search and Filter Functionality**
  - Enable users to search for content based on various criteria (keywords, date, content type, etc.).
  - Provide filtering options to narrow down search results.
  - Support advanced search features for more specific queries.

## Domain Modeling

 - **User**: Represents a user of the CMS.
    - Attributes:
        - userID: Unique identifier for the user.
        - username: Username of the user.
        - password: Password of the user.
        - email: Email address of the user.
        - role: Role of the user (Administrator, Reviewer, Contributor).
 - **Content**: Represents the digital content managed by the CMS.
    - Attributes:
        - contentID: Unique identifier for the content.
        - title: Title of the content.
        - type: Type of content (Text, Image, Video).
        - status: Current status of the content (Draft, Reviewed, Published).
        - version: Version of the content.
        - createdDate: Date the content was created.
        - updatedDate: Date the content was last updated.
    - Relationships:
Each Content can have multiple Comments.
Each Content can be published on multiple Platforms.
 - **Task**: Represents a task assigned to a contributor.
    - Attributes:
        - taskID: Unique identifier for the task.
        - assignedDate: Date the task was assigned.
        - dueDate: Due date for the task.
        - status: Current status of the task.
        - description: Description of the task.
    - Relationships:
Each Task is associated with one User (Contributor).
 - **Comment**: Represents a comment made on content during the review process.
    - Attributes:
        - commentID: Unique identifier for the comment.
        - text: Text of the comment.
        - createdDate: Date the comment was created.
    - Relationships:
Each Comment is associated with one Content.
 - **Platform**: Represents a platform where content can be published.
    - Attributes:
        - platformID: Unique identifier for the platform.
        - name: Name of the platform.
        - url: URL of the platform.
    - Relationships:
Each Platform can be associated with multiple Content.