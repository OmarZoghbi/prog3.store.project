<template>
  <ul>
    <li v-for="(item, index) in items" :key="index">
      {{ item }}
    </li>
  </ul>
</template>

<script setup lang="ts">
const items = ['Alo-Vera-Gel', 'Kokosöl-Haarmaske', 'Lavendelseife', 'Bartöl'];
</script>
