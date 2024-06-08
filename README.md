# Content Management System

## Problem Statement & Description

### Project Statement
The project aims to solve the problem of inefficient content creation, organization, collaboration, and publishing. Organizations and individuals often struggle due to the lack of a centralized platform, leading to scattered content, inconsistent formatting, and difficulties with collaboration and version control. This results in delays, miscommunication, and poor content quality. This project proposes building a comprehensive content management system (CMS) to address these issues.
### Description
The CMS will provide users with a single platform to efficiently upload, organize, collaborate on, and publish digital content, including pictures, text, and videos. It will streamline the content creation process, enhance teamwork, and improve version control, ultimately leading to higher-quality content and a more efficient workflow.

- The system will support multiple user roles: administrators, reviewers, and contributors.
    - Administrators can manage user roles, give out tasks, and publish content to various platforms (YouTube, TikTok, Instagram, Twitter).
    - Contributors can upload, organize, and create content, sending it to reviewers for approval.
    - Reviewers can provide feedback, make changes, and approve content for publication.

- The system will track all published and draft content and all changes made to the content after creation. The workflow on our CMS starts when administrators create tasks that contain a title of the task, a description of what should be done, platforms the content would be uploaded to, a deadline, and other fields. Administrators then add tasks to a contributor’s task queue. Contributors take a task from their queue, which will ask them to create some kind of content, after creating the content they send the task with the created content to a queue of tasks to be reviewed by reviewers. Reviewers take a task from the queue and if the task is not publishable in its current state they will send it back to the contributor’s task queue, if the task is publishable the reviewer will send it to a queue of tasks waiting to be published by administrators. Administrators will then go through the queue to publish the content to the appropriate platforms.

### Functional Requirements Analysis

#### User Roles and Permissions
1. **Administrators**
    - **Manage User Roles:** Add, remove, and modify user roles and permissions.
    - **Task Management:** Create, assign, and oversee tasks for contributors.
    - **Publishing:** Publish approved content to various platforms (YouTube, TikTok, Instagram, Twitter).
    - **Content Tracking:** Track all changes, versions, and status of content.

2. **Contributors**
    - **Content Creation:** Upload, organize, and create content based on assigned tasks.
    - **Task Management:** View assigned tasks, update task status, and submit content for review.
    - **Feedback Handling:** Receive and address feedback from reviewers, resubmit content if needed.

3. **Reviewers**
    - **Content Review:** Review content submitted by contributors, provide feedback, and make necessary changes.
    - **Approval Process:** Approve content for publication or send it back to contributors for revisions.
    - **Content Tracking:** Track the status and changes made to the content during the review process.

#### Functional Requirements
1. **User Management**
    - **Create/Manage Users:** Administrators can add new users, assign roles, and manage existing users.
    - **Role-Based Access Control:** Different user roles with specific permissions and capabilities.

2. **Task Management**
    - **Create Tasks:** Administrators can create tasks with detailed descriptions, deadlines, and target platforms.
    - **Assign Tasks:** Tasks can be assigned to contributors by administrators.
    - **Task Queues:** Tasks are organized in queues based on their current status (e.g., assigned, in review, waiting for publication).

3. **Content Management**
    - **Upload Content:** Contributors can upload various types of digital content (text, images, videos).
    - **Organize Content:** Contributors can organize content into folders or categories.
    - **Edit Content:** Basic editing tools for contributors to modify content.

4. **Review and Feedback**
    - **Content Review:** Reviewers can access submitted content, provide feedback, and make edits.
    - **Approval/Rejection:** Reviewers can approve content for publication or reject it with feedback for revisions.
    - **Notification System:** Notify contributors about feedback and required changes.

5. **Publishing**
    - **Publish Content:** Administrators can publish approved content to designated platforms.
    - **Platform Integration:** Integrate with YouTube, TikTok, Instagram, and Twitter for seamless content publishing.

6. **Version Control**
    - **Track Changes:** Maintain a history of changes made to content, including who made the changes and when.
    - **Drafts and Versions:** Save drafts and manage multiple versions of content.

7. **Content Tracking**
    - **Status Tracking:** Track the status of each content item (draft, in review, approved, published).
    - **Audit Trail:** Keep an audit trail of all actions taken on content (creation, edits, approvals, rejections).

### System Analysis & Design

#### System Components and Their Responsibilities

1. **User Management**
    - **User**: Represents a user in the system with attributes like username, password, email, and role.
    - **Role**: Defines different roles in the system (Administrator, Contributor, Reviewer).

2. **Task Management**
    - **Task**: Represents a task with attributes like title, description, deadline, status, and target platforms.
    - **TaskQueue**: Manages the queue of tasks based on their status (assigned, in review, waiting for publication).

3. **Content Management**
    - **Content**: Represents digital content with attributes like contentId, type, data, and version.
    - **ContentHistory**: Keeps track of changes made to content with attributes like changeId, changeDate, and changeDescription.

4. **Review and Feedback**
    - **Review**: Represents a review action with attributes like reviewId, feedback, and status.

5. **Publishing**
    - **PublishingPlatform**: Represents the different platforms content can be published to with attributes like platformId, platformName, and APIIntegrationDetails.

### Class Diagram Explanation

1. **User and Role Relationship**
    - A `User` has a `Role`. The role determines the capabilities and permissions of the user in the system.

2. **Task Management**
    - A `Task` is associated with a `User` who is assigned to it.
    - Tasks are organized in a `TaskQueue` based on their status. Each queue contains a list of tasks.

3. **Content Management**
    - `Content` is created by a `User` (Contributor). Each piece of content has a version to manage changes.
    - `ContentHistory` tracks all changes made to the content, linked back to the original content.

4. **Review and Feedback**
    - `Review` links a piece of `Content` with a `User` (Reviewer) who provides feedback and changes its status.

5. **Publishing**
    - `PublishingPlatform` represents various platforms where content can be published, including integration details.


### Domain Model UML Class Diagram
