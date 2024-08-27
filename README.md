Unified Connection Management: Centralized utility class for managing database connections, including opening and closing connections.
Configuration via Properties File: Uses an external properties file (db.properties) to manage database connection settings (URL, username, password), allowing dynamic updates without code modifications.
JDBC 4.x Compatibility: Utilizes JDBC 4.x autoloading features to automatically load the appropriate database driver based on the JDBC URL.
