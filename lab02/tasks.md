# Java tasks & Git

Before you continue with todays training we advice you finish all tasks from lab01

# [Git] Task 0 Setup your GitHub account and prepare your repository
 - Create GitHub account
 - Download and install git [git-scm](https://git-scm.com/downloads)
 - Generate SSH key for GitHub authentication [ssh-gen-paper](https://www.purdue.edu/science/scienceit/ssh-keys-windows.html)
  Example for ssh command with Windows
  ```
  ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
  ```
  for mac it's located inside '/Users/YourUsername/.ssh/id_rsa' for windows 'C:\Users\YourUsername\.ssh\id_rsa'
 - Setup SSH with GitHub [documentation](https://docs.github.com/en/authentication/connecting-to-github-with-ssh) 
 - Create repository and clone it or init local repository and later on connect you remote repository

# [Git] Practice merge on local repository (together or with the cheatsheet)
1. Create folder 'git-lab-02' and init repository inside it
<details>
<summary>Steps</summary>

```sh
mkdir git-lab-02
cd git-lab-02
git init
```

</details>

2. Create initial commit creating a text file
<details>
<summary>Steps</summary>

```sh
echo "Hello, Git World" > greeting.txt
git add greeting.txt
git commit -m "Initial commit for adding the first line of greeting.txt"
```

</details>

3. Create a feature branch. You receive a task in which you need to add one more line to the greeting.txt
<details>
<summary>Steps</summary>


## Create and switch to a new branch
```sh
git checkout -b feature-branch
```
## Make changes in the feature branch
```sh
echo "Hello from the feature branch" > greeting.txt
git add greeting.txt
git commit -m "Update from feature branch to greeting.txt"
```

</details>

4. Return to master branch and alter greeting.txt file
<details>
<summary>Steps</summary>


## Switch back to the master branch
```sh
git checkout master
```
## Make conflicting changes in the master branch
```sh
echo "Hello from the master branch" > greeting.txt
git add greeting.txt
git commit -m "Update from master branch"

```

</details>

5. Merge feature-branh to master
<details>
<summary>Steps</summary>


## Attempt to merge feature-branch into master
```sh
git merge feature-branch
```

## Result
```
Auto-merging greeting.txt
CONFLICT (content): Merge conflict in greeting.txt
Automatic merge failed; fix conflicts and then commit the result.
```
</details>

6. Resolve conflicts

<details>
<summary>Steps</summary>

## Validate where are your conflicted lines
Open the conflicting file in a text editor and resolve the conflicts
For example, the file might look like this:
```
<<<<<<< HEAD
Hello from the master branch
=======
Hello from the feature branch
>>>>>>> feature-branch
```
Remove the lines and add: 'Hello from both branches'

```sh
vi greeting.txt
#alter file by entering 'i' (edit mode), delete lines and add the appropriate line. Close with :wq
```

## Execute after save
After resolving it could look like this:
Hello from both branches

## After resolving the conflict, add the file and commit the resolution
```sh
git add greeting.txt
git commit -m "Resolve merge conflict between master and feature branch"
git log --all --decorate --oneline --graph
```

</details>
