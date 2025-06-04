<template>
  <div>
    <h2 @click="toggleList" style="cursor: pointer;">
      Artikel im Shop
    </h2>

    <ul v-if="showItems">
      <li v-for="(item, index) in items" :key="index">
        <strong>{{ item.name }}</strong><br />
        <em>{{ item.description }}</em><br />
        <span :style="{ color: item.available ? 'green' : 'red' }">
          Verfügbar: {{ item.available ? '✅' : '❌' }}
        </span>
      </li>
    </ul>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';

interface Article {
  name: string;
  description: string;
  available: boolean;
}

const items = ref<Article[]>([]);
const showItems = ref(false);

function toggleList() {
  showItems.value = !showItems.value;
}

onMounted(async () => {
  try {
    const response = await fetch('http://localhost:8080/api/articles');
    if (!response.ok) throw new Error('Fehler beim Abrufen');
    items.value = await response.json();
  } catch (error) {
    console.error('Fehler beim Laden:', error);
  }
});
</script>
