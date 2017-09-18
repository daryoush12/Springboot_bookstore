CREATE TABLE Users (
    u_userID int NOT NULL,
    u_userName VARCHAR(255) NOT NULL UNIQUE KEY,
	u_password_hash VARCHAR(255) NOT NULL,
	u_salt VARCHAR(255) NOT NULL,
	u_Admin tinyint(1) NOT NULL,
	u_firstName VARCHAR(20),
	u_lastName VARCHAR(20),
	u_email VARCHAR(25)NOT NULL,
    PRIMARY KEY (u_userID)
); 
CREATE TABLE Posts (
    post_ID int NOT NULL,
    post_AuthorID int NOT NULL,
	post_title VARCHAR(255) NOT NULL,
	post_content VARCHAR(255) NOT NULL,
	post_date DATE NOT NULL,
	post_imageUrl VARCHAR(255)NOT NULL,
    PRIMARY KEY (post_ID),
    FOREIGN KEY (post_AuthorID) REFERENCES Users(u_userID)
); 
CREATE TABLE Post_Comments (
    comment_ID int NOT NULL,
	comment_Content VARCHAR(255) NOT NULL,
    post_ID int NOT NULL,
	ParentToID int,
    PRIMARY KEY (comment_ID),
    FOREIGN KEY (post_ID) REFERENCES Posts(post_ID),
	FOREIGN KEY (ParentToID) REFERENCES Post_Comments(comment_ID)
); 