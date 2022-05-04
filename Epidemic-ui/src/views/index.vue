<template>
    <div class="app-container home">
        <img width="100%" src="@/assets/images/index.jpg" />
    </div>
</template>

<script>
export default {
    name: "Index",
    data() {
        return {};
    },
    methods: {
        goTarget(href) {
            window.open(href, "_blank");
        },
    },
};
</script>

<style scoped lang="scss">
</style>

