<h1 align="center">Watchly - Movie Streaming and Review App</h1>

<p align="center">
  <strong>Watchly</strong> is an Android application that allows users to browse movies, read reviews, and stream content seamlessly. The app integrates with the <strong>IMDb API</strong> for movie data and uses <strong>Amazon S3</strong> for secure and efficient movie streaming. It also includes user authentication (login/signup) for a personalized experience.
</p>

---

<h2>✨ Features</h2>
<ul>
  <li><strong>Movie Details</strong>: Fetch and display movie information, including titles, descriptions, ratings, and reviews, using the IMDb API.</li>
  <li><strong>Movie Streaming</strong>: Stream movies directly from <strong>Amazon S3</strong> buckets.</li>
  <li><strong>Responsive UI</strong>: Clean and intuitive user interface with smooth navigation.</li>
  <li><strong>Offline Support</strong>: Cache user preferences and movie data locally using <strong>SQLite</strong>.</li>
</ul>

---

<h2>🛠 Technologies Used</h2>
<ul>
  <li><strong>Frontend</strong>: Android (Java)</li>
  <li><strong>Backend</strong>: XML, Java</li>
  <li><strong>Cloud Storage</strong>: Amazon S3</li>
</ul>

---

<h2>🚀 Setup Instructions</h2>

<h3>Prerequisites</h3>
<ul>
  <li>Android Studio</li>
  <li>Amazon S3 bucket for movie storage</li>
  <li>IMDb API key</li>
</ul>

<h3>Steps to Run the Project</h3>
<ol>
  <li><strong>Clone the Repository</strong>:
    <pre><code>git clone https://github.com/wistrum/Watchly.git</code></pre>
  </li>
  <li><strong>Open the Project in Android Studio</strong>:
    <ul>
      <li>Launch Android Studio and select <code>Open Project</code>.</li>
      <li>Navigate to the cloned <code>Watchly</code> folder and open it.</li>
    </ul>
  </li>
  <li><strong>Set Up Amazon S3</strong>:
    <ul>
      <li>Create an S3 bucket on AWS and upload your movie files.</li>
      <li>Update the S3 bucket name and credentials in the app's configuration files.</li>
    </ul>
  </li>
  <li><strong>Add IMDb API Key</strong>:
    <ul>
      <li>Sign up for an IMDb API key and add it to the app's configuration.</li>
    </ul>
  </li>
  <li><strong>Build and Run</strong>:
    <ul>
      <li>Connect an Android device or emulator.</li>
      <li>Click <code>Run</code> in Android Studio to build and launch the app.</li>
    </ul>
  </li>
</ol>

---
