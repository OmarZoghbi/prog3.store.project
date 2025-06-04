<template>
  <div class="app-container">
    <h1>Mein Online-Shop</h1>
    <ArticleList />
  </div>
</template>

<script setup lang="ts">
import ArticleList from './components/ArticleList.vue';
</script>

<style>
.app-container {
  padding: 2rem;
  font-family: Arial, sans-serif;
  color: #ddd;
}

h1 {
  margin-bottom: 1rem;
}

button {
  margin: 1rem 0;
  padding: 0.5rem 1rem;
  font-size: 1rem;
  cursor: pointer;
}

ul {
  list-style: none;
  padding: 0;
}

li {
  margin-bottom: 1.5rem;
}

strong {
  font-size: 1.1rem;
}
</style>
